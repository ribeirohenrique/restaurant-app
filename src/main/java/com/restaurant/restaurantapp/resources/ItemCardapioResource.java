package com.restaurant.restaurantapp.resources;


import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.entities.dtos.ItemCardapioDto;
import com.restaurant.restaurantapp.service.ItemCardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/itenscardapio", produces = "application/json", consumes = "application/json")
public class ItemCardapioResource {

    @Autowired
    private ItemCardapioService itemCardapioService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemCardapioDto> findById(@PathVariable Long id) {
        ItemCardapio itemCardapio = itemCardapioService.findById(id);
        return ResponseEntity.ok().body(new ItemCardapioDto(itemCardapio));
    }
}