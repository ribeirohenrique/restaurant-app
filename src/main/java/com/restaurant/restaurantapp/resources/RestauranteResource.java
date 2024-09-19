package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.entities.dtos.RestauranteDto;
import com.restaurant.restaurantapp.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restaurantes", produces = "application/json", consumes = "application/json")
public class RestauranteResource {

    @Autowired
    private RestauranteService restauranteService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<RestauranteDto> findById(@PathVariable Long id) {
        Restaurante restaurante = restauranteService.findById(id);
        return ResponseEntity.ok().body(new RestauranteDto(restaurante));
    }
}
