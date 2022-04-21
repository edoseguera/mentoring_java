package com.danieloseguera.accountsservice.repository;

import com.danieloseguera.accountsservice.model.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
    Page<Account> findAll(Pageable pageable);
}
