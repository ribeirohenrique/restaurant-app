package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.repository.ItemCardapioRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCardapioService {

    @Autowired
    private ItemCardapioRepository itemCardapioRepository;

    // Procurar por Id
    public ItemCardapio findById(Long id) {
        Optional<ItemCardapio> itemCardapio = itemCardapioRepository.findById(id);
        return itemCardapio.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<ItemCardapio> findAll() {
        return itemCardapioRepository.findAll();
    }

    // Criar
    public ItemCardapio insert(ItemCardapio itemCardapio) {
        try {
            itemCardapioRepository.save(itemCardapio);
            return itemCardapio;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(itemCardapio.getId());
        }
    }

    // Atualizar
    public ItemCardapio update(Long id, ItemCardapio itemCardapio) {
        try {
            ItemCardapio existingItem = findById(id);
            existingItem.setNome(itemCardapio.getNome());
            existingItem.setDescricao(itemCardapio.getDescricao());
            existingItem.setPreco(itemCardapio.getPreco());
            existingItem.setCardapio(itemCardapio.getCardapio());
            return itemCardapioRepository.save(existingItem);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            ItemCardapio itemCardapio = findById(id);
            itemCardapioRepository.delete(itemCardapio);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
