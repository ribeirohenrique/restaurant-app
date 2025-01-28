package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.repository.ClienteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Procurar por Id
    public Cliente findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Criar
    public Cliente insert(Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            return cliente;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(cliente.getId());
        }
    }

    // Atualizar
    public Cliente update(Long id, Cliente cliente) {
        try {
            Cliente existingCliente = findById(id);
            existingCliente.setNome(cliente.getNome());
            existingCliente.setCpf(cliente.getCpf());
            existingCliente.setEmail(cliente.getEmail());
            return clienteRepository.save(existingCliente);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            Cliente cliente = findById(id);
            clienteRepository.delete(cliente);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
