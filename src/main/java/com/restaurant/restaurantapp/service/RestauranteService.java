package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.repository.RestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    // Procurar por Id
    public Restaurante findById(Long id) {
        Optional<Restaurante> restaurante = restauranteRepository.findById(id);
        return restaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    // Criar
    public Restaurante insert(Restaurante restaurante) {
        try {
            restauranteRepository.save(restaurante);
            return restaurante;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(restaurante.getId());
        }
    }

    // Atualizar
    public Restaurante update(Long id, Restaurante restaurante) {
        try {
            Restaurante existingRestaurante = findById(id);
            existingRestaurante.setNome(restaurante.getNome());
            existingRestaurante.setTelefone(restaurante.getTelefone());
            existingRestaurante.setPedidos(restaurante.getPedidos());
            existingRestaurante.setCardapio(restaurante.getCardapio());
            existingRestaurante.setEnderecoRestaurante(restaurante.getEnderecoRestaurante());
            return restauranteRepository.save(existingRestaurante);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            Restaurante restaurante = findById(id);
            restauranteRepository.delete(restaurante);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
