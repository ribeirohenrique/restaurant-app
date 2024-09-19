package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.repository.ClienteRepository;
import com.restaurant.restaurantapp.repository.EnderecoRestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoRestauranteService {

    @Autowired
    private EnderecoRestauranteRepository enderecoRestauranteRepository;

    public EnderecoRestaurante findById(Long id) {
        Optional<EnderecoRestaurante> enderecoRestaurante = enderecoRestauranteRepository.findById(id);
        return enderecoRestaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
