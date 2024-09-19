package com.restaurant.restaurantapp.service.exceptions;

public class AccountBalanceException extends RuntimeException {

    public AccountBalanceException(Object resource) {
        super("Insufficient account balance");
    }
}
