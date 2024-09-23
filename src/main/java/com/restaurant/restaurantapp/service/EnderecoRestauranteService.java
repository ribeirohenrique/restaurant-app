package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.repository.ClienteRepository;
import com.restaurant.restaurantapp.repository.EnderecoRestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoRestauranteService {

    @Autowired
    private EnderecoRestauranteRepository enderecoRestauranteRepository;

    //Procurar por Id
    public EnderecoRestaurante findById(Long id) {
        Optional<EnderecoRestaurante> enderecoRestaurante = enderecoRestauranteRepository.findById(id);
        return enderecoRestaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public EnderecoRestaurante insert(EnderecoRestaurante enderecoRestaurante) {
        try {
            enderecoRestauranteRepository.save(enderecoRestaurante);
            return enderecoRestaurante;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(enderecoRestaurante.getId());
        }
    }
}
