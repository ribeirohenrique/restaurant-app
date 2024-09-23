package com.restaurant.restaurantapp.resources;


import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.entities.dtos.ItemCardapioDto;
import com.restaurant.restaurantapp.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/itenscardapio", produces = "application/json", consumes = "application/json")
public class ItemCardapioResource {

    @Autowired
    private ItemCardapioService itemCardapioService;

    //Encontrar por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemCardapioDto> findById(@PathVariable Long id) {
        ItemCardapio itemCardapio = itemCardapioService.findById(id);
        return ResponseEntity.ok().body(new ItemCardapioDto(itemCardapio));
    }

    //Criar
    @PostMapping
    public ResponseEntity<ItemCardapioDto> insert(@RequestBody ItemCardapio itemCardapio) {
        itemCardapio = itemCardapioService.insert(itemCardapio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(itemCardapio.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemCardapioDto(itemCardapio));
    }
}