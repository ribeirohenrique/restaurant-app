package com.restaurant.restaurantapp.resources;


import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.entities.dtos.CardapioDto;
import com.restaurant.restaurantapp.entities.dtos.ItemCardapioDto;
import com.restaurant.restaurantapp.service.CardapioService;
import com.restaurant.restaurantapp.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/cardapios", produces = "application/json", consumes = "application/json")
public class CardapioResource {

    @Autowired
    private CardapioService cardapioService;

    //Encontrar por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<CardapioDto> findById(@PathVariable Long id) {
        Cardapio cardapio = cardapioService.findById(id);
        return ResponseEntity.ok().body(new CardapioDto(cardapio));
    }

    //Criar
    @PostMapping
    public ResponseEntity<CardapioDto> insert(@RequestBody Cardapio cardapio) {
        cardapio = cardapioService.insert(cardapio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cardapio.getId()).toUri();
        return ResponseEntity.created(uri).body(new CardapioDto(cardapio));
    }
}