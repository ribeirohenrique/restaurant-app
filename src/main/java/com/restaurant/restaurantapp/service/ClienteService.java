package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.repository.ClienteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //Procurar por Id
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public Cliente insert(Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            return cliente;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(cliente.getId());
        }
    }
}
