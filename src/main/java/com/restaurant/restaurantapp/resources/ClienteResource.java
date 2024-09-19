package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes", produces = "application/json", consumes = "application/json")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(new ClienteDto(cliente));
    }
}
