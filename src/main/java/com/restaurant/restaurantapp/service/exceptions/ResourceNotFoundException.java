package com.restaurant.restaurantapp.service.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object resource) {
        super("Resource not found: " + resource);
    }
}
