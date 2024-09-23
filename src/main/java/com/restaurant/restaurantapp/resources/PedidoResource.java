package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Cliente;
import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.dtos.ClienteDto;
import com.restaurant.restaurantapp.entities.dtos.PedidoDto;
import com.restaurant.restaurantapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pedidos", produces = "application/json", consumes = "application/json")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(new PedidoDto(pedido));
    }

    //Criar
    @PostMapping
    public ResponseEntity<PedidoDto> insert(@RequestBody Pedido pedido) {
        pedido = pedidoService.insert(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }
}
