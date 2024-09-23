package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.repository.CardapioRepository;
import com.restaurant.restaurantapp.repository.ItemCardapioRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    //Procurar por Id
    public Cardapio findById(Long id) {
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        return cardapio.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public Cardapio insert(Cardapio cardapio) {
        try {
            cardapioRepository.save(cardapio);
            return cardapio;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(cardapio.getId());
        }
    }
}
