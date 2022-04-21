package com.danieloseguera.accountsservice.controller;

import com.danieloseguera.accountsservice.dto.AccountDto;
import com.danieloseguera.accountsservice.model.Account;
import com.danieloseguera.accountsservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class BankAccountController {

    private AccountService accountServiceImpl;

    @GetMapping
    public ResponseEntity<Page<Account>> findAll(Pageable pageable) {
        return ResponseEntity.ok(accountServiceImpl.findAll(pageable));
    }

    @PostMapping
        public ResponseEntity<Account> saveAccount(@Valid @RequestBody AccountDto account) {
        return ResponseEntity.ok(accountServiceImpl.saveAccount(account));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> findAll(@PathVariable Integer accountId, Pageable pageable) {
        return ResponseEntity.ok(accountServiceImpl.findAccountById(accountId));
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@Valid @RequestBody AccountDto accountDto, @PathVariable Integer accountId) {
        return ResponseEntity.ok(accountServiceImpl.updateAccount(accountDto, accountId));
    }

}
