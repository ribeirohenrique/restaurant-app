package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.entities.dtos.EnderecoRestauranteDto;
import com.restaurant.restaurantapp.service.ClienteService;
import com.restaurant.restaurantapp.service.EnderecoRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/enderecosrestaurantes", produces = "application/json", consumes = "application/json")
public class EnderecoRestauranteResource {

    @Autowired
    private EnderecoRestauranteService enderecoRestauranteService;

    //Encontrar por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<EnderecoRestauranteDto> findById(@PathVariable Long id) {
        EnderecoRestaurante enderecoRestaurante = enderecoRestauranteService.findById(id);
        return ResponseEntity.ok().body(new EnderecoRestauranteDto(enderecoRestaurante));
    }

    //Criar
    @PostMapping
    public ResponseEntity<EnderecoRestauranteDto> insert(@RequestBody EnderecoRestaurante enderecoRestaurante) {
        enderecoRestaurante = enderecoRestauranteService.insert(enderecoRestaurante);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecoRestaurante.getId()).toUri();
        return ResponseEntity.created(uri).body(new EnderecoRestauranteDto(enderecoRestaurante));
    }
}
