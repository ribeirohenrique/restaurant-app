package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.repository.ClienteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
