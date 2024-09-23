package com.restaurant.restaurantapp.service.exceptions;

public class ResourceDuplicatedException extends RuntimeException {

    public ResourceDuplicatedException(Object resource) {
        super("Resource already exists: " + resource);
    }
}
