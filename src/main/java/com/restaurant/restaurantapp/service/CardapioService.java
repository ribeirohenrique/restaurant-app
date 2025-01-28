package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.repository.CardapioRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    // Procurar por Id
    public Cardapio findById(Long id) {
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        return cardapio.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<Cardapio> findAll() {
        return cardapioRepository.findAll();
    }

    // Criar
    public Cardapio insert(Cardapio cardapio) {
        try {
            cardapioRepository.save(cardapio);
            return cardapio;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(cardapio.getId());
        }
    }

    // Atualizar
    public Cardapio update(Long id, Cardapio cardapio) {
        try {
            Cardapio existingCardapio = findById(id);
            existingCardapio.setNome(cardapio.getNome());
            existingCardapio.setRestaurante(cardapio.getRestaurante());
            existingCardapio.setItens(cardapio.getItens());
            return cardapioRepository.save(existingCardapio);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            Cardapio cardapio = findById(id);
            cardapioRepository.delete(cardapio);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
