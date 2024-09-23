package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.repository.RestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    //Procurar por Id
    public Restaurante findById(Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        return restaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public Restaurante insert(Restaurante restaurante) {
        try {
            restauranteRepository.save(restaurante);
            return restaurante;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(restaurante.getId());
        }
    }
}
