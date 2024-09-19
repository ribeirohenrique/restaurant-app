package com.restaurant.restaurantapp.resources;

import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.dtos.PedidoDto;
import com.restaurant.restaurantapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos", produces = "application/json", consumes = "application/json")
public class CardapioResource {

    @Autowired
    private PedidoService pedidoService;

    //Encontrar conta por Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id) {
        Pedido pedido = pedidoService.findById(id);
        return ResponseEntity.ok().body(new PedidoDto(pedido));
    }
}
