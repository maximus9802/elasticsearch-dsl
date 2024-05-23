package com.quyvx.elasticspringboot.repository;

import com.quyvx.elasticspringboot.entity.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountRepository extends ElasticsearchRepository<Account, String> {

}
