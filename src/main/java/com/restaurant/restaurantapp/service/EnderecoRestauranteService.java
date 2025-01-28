package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.repository.EnderecoRestauranteRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoRestauranteService {

    @Autowired
    private EnderecoRestauranteRepository enderecoRestauranteRepository;

    // Procurar por Id
    public EnderecoRestaurante findById(Long id) {
        Optional<EnderecoRestaurante> enderecoRestaurante = enderecoRestauranteRepository.findById(id);
        return enderecoRestaurante.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<EnderecoRestaurante> findAll() {
        return enderecoRestauranteRepository.findAll();
    }

    // Criar
    public EnderecoRestaurante insert(EnderecoRestaurante enderecoRestaurante) {
        try {
            enderecoRestauranteRepository.save(enderecoRestaurante);
            return enderecoRestaurante;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(enderecoRestaurante.getId());
        }
    }

    // Atualizar
    public EnderecoRestaurante update(Long id, EnderecoRestaurante enderecoRestaurante) {
        try {
            EnderecoRestaurante existingEndereco = findById(id);
            existingEndereco.setEndereco(enderecoRestaurante.getEndereco());
            existingEndereco.setNumero(enderecoRestaurante.getNumero());
            existingEndereco.setCep(enderecoRestaurante.getCep());
            existingEndereco.setBairro(enderecoRestaurante.getBairro());
            existingEndereco.setCidade(enderecoRestaurante.getCidade());
            existingEndereco.setRestaurante(enderecoRestaurante.getRestaurante());
            return enderecoRestauranteRepository.save(existingEndereco);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            EnderecoRestaurante enderecoRestaurante = findById(id);
            enderecoRestauranteRepository.delete(enderecoRestaurante);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
