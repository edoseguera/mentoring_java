package com.danieloseguera.accountsservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountDto {
    @NotNull
    @NotBlank
    private String ownerName;

    @NotNull
    @NotBlank
    private String bankName;

    @NotNull
    @NotBlank
    private String interbankKey;

    @NotNull
    @NotBlank
    private String relationship;
}
