package com.danieloseguera.accountsservice.mapper;

import com.danieloseguera.accountsservice.dto.AccountDto;
import com.danieloseguera.accountsservice.model.Account;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAccountFromDto(AccountDto accountDto, @MappingTarget Account account);

    Account toAccount(AccountDto accountDto);
}
