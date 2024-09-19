package com.restaurant.restaurantapp.service.exceptions;

public class AccountDuplicateException extends RuntimeException {

    public AccountDuplicateException(Object resource) {
        super("Account already exists: " + resource);
    }
}
