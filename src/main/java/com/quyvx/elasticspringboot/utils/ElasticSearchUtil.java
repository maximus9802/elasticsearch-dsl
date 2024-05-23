package com.quyvx.elasticspringboot.utils;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class ElasticSearchUtil {

    public static Supplier<Query> supplier() {
        return ()->Query.of(q -> q.matchAll(matchAllQuery()));
    }

    public static MatchAllQuery matchAllQuery() {
        val mathAllQuery = new MatchAllQuery.Builder();
        return mathAllQuery.build();
    }

    public static Supplier<Query> supplierWithField(String fieldMatch, String fieldValue) {
        return ()-> Query.of(q ->q.match(matchQueryWithField(fieldMatch, fieldValue)));
    }

    public static MatchQuery matchQueryWithField(String field, String fieldValue) {
        val matchQuery = new MatchQuery.Builder();
        matchQuery.field(field).query(fieldValue);
        return matchQuery.build();
    }
}
