package com.restaurant.restaurantapp.service.exceptions;

public class AccountLimitException extends RuntimeException {

    public AccountLimitException(Object resource) {
        super("Insufficient account limit");
    }
}
