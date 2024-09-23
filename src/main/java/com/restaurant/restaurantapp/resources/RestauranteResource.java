package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.Restaurante;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.entities.dtos.RestauranteDto;
import com.restaurant.restaurantapp.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    //Criar
    @PostMapping
    public ResponseEntity<RestauranteDto> insert(@RequestBody Restaurante restaurante) {
        restaurante = restauranteService.insert(restaurante);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(restaurante.getId()).toUri();
        return ResponseEntity.created(uri).body(new RestauranteDto(restaurante));
    }
}
