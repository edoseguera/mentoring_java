package com.danieloseguera.accountsservice.service;

import com.danieloseguera.accountsservice.dto.AccountDto;
import com.danieloseguera.accountsservice.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountService {
    Page<Account> findAll(Pageable pageable);
    Account saveAccount(AccountDto accountDto);
    Account findAccountById(Integer accountId);
    Account updateAccount(AccountDto accountDto, Integer accountId);
}
