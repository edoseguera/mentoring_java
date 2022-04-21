package com.danieloseguera.accountsservice.service.impl;

import com.danieloseguera.accountsservice.dto.AccountDto;
import com.danieloseguera.accountsservice.exception.AccountNotFoundException;
import com.danieloseguera.accountsservice.exception.AccountUniqueException;
import com.danieloseguera.accountsservice.mapper.AccountMapper;
import com.danieloseguera.accountsservice.model.Account;
import com.danieloseguera.accountsservice.repository.AccountRepository;
import com.danieloseguera.accountsservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Transactional
    public Account saveAccount(AccountDto accountDto) {
        try {
            Account account = accountMapper.toAccount(accountDto);
            return accountRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            log.error("Error creating account in the database: {}", e.getMessage(), e);
            throw new AccountUniqueException("The interbank key should be unique, already someone exists", e);
        }
    }

    public Account findAccountById(Integer accountId) {
        verifyExistsAccount(accountId);
        return accountRepository.findById(accountId).get();
    }

    @Transactional
    public Account updateAccount(AccountDto accountDto, Integer accountId) {
        verifyExistsAccount(accountId);

        try {
            Account account = accountRepository.findById(accountId).get();
            accountMapper.updateAccountFromDto(accountDto, account);
            return accountRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            log.error("Error updating the account {} in the database: {}", accountId, e.getMessage(), e);
            throw new AccountUniqueException("The interbank key should be unique, already someone exists", e);
        }
    }

    private void verifyExistsAccount(Integer accountId) {
        if (!accountRepository.existsById(accountId)) {
            log.warn("Account: {} not found in the database", accountId);
            throw new AccountNotFoundException("Account not found");
        }
    }

}
