package com.quyvx.elasticspringboot.service;

import com.quyvx.elasticspringboot.entity.Account;
import com.quyvx.elasticspringboot.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(String id) {
        return  accountRepository.findById(id).orElse(null);
    }

}
