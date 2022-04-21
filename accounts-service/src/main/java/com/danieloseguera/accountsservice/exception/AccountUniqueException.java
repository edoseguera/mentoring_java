package com.danieloseguera.accountsservice.exception;

public class AccountUniqueException extends RuntimeException {
    public AccountUniqueException(String message) {
        super(message);
    }

    public AccountUniqueException(String message, Throwable e) {
        super(message, e);
    }
}
