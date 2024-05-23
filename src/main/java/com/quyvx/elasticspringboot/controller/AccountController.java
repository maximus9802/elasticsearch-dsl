package com.quyvx.elasticspringboot.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.quyvx.elasticspringboot.entity.Account;
import com.quyvx.elasticspringboot.service.ElasticSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final ElasticSearchService elasticSearchService;

    public SearchResponse<Map> mathAll() throws IOException {
        return elasticSearchService.matchAllServices();
    }

    @GetMapping("/matchAllAccounts")
    public List<Account> matchAllAccounts() throws IOException {
        SearchResponse<Account> searchResponse = elasticSearchService.matchAllAccountService();
        System.out.println(searchResponse.hits().toString());

        List<Hit<Account>> listOfHits = searchResponse.hits().hits();
        List<Account> listOfAccounts = new ArrayList<>();

        listOfHits.forEach(p-> listOfAccounts.add(p.source()));

        return listOfAccounts;
    }


    @GetMapping("/field")
    public List<Account> matchFieldAndFieldValue(@RequestParam("field") String field,
                                                 @RequestParam("fieldValue") String fieldValue) throws IOException {
        SearchResponse<Account> searchResponse = elasticSearchService
                .matchAccountsWithFieldAndFieldValue(field, fieldValue);

        List<Hit<Account>> listOfHits = searchResponse.hits().hits();
        List<Account> listOfAccounts = new ArrayList<>();

        listOfHits.forEach(p-> listOfAccounts.add(p.source()));

        return listOfAccounts;
    }

    @GetMapping("/field_and_paging")
    public List<Account> matchFieldAndFieldValueAndPaging(@RequestParam("field") String field,
                                                          @RequestParam("fieldValue") String fieldValue,
                                                          @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                                                          @RequestParam(value = "offset", defaultValue = "0") Integer offset) throws IOException {
        SearchResponse<Account> searchResponse = elasticSearchService
                .matchAccountsWithFieldAndFieldValueAndPaging(field, fieldValue, limit, offset);

        List<Hit<Account>> listOfHits = searchResponse.hits().hits();
        List<Account> listOfAccounts = new ArrayList<>();

        listOfHits.forEach(p-> listOfAccounts.add(p.source()));

        return listOfAccounts;
    }
}
