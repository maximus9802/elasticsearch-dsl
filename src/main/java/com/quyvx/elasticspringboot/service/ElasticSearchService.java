package com.quyvx.elasticspringboot.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.quyvx.elasticspringboot.entity.Account;
import com.quyvx.elasticspringboot.utils.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class ElasticSearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Map> matchAllServices( ) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Map> searchResponse =  elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);
        System.out.println("Elasticsearch query is " + supplier.get().toString());
        return searchResponse;
    }

    public SearchResponse<Account> matchAllAccountService() throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplier();
        SearchResponse<Account> searchResponse = elasticsearchClient.search(s -> s.index("bank").query(supplier.get()), Account.class);
        System.out.println("Elasticsearch query is " + supplier.get().toString());
        return searchResponse;
    }

    public SearchResponse<Account> matchAccountsWithFieldAndFieldValue(String field, String fieldValue) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplierWithField(field, fieldValue);
        return elasticsearchClient.search(s -> s
                .index("bank")
                .query(supplier.get())
                , Account.class);
    }

    public SearchResponse<Account> matchAccountsWithFieldAndFieldValueAndPaging(String field, String fieldValue, Integer limit, Integer offset) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.supplierWithField(field, fieldValue);
        return elasticsearchClient.search(s -> s
                        .index("bank")
                        .query(supplier.get())
                        .size(limit)
                        .from(offset)
                , Account.class);
    }
}
