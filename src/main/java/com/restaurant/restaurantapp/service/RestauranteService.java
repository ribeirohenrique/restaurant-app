package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.repository.RestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    //encontrar pedido por Id
    public Restaurante findById(Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        return restaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
