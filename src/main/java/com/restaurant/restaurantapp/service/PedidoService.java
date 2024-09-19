package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.repository.PedidoRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    //encontrar pedido por Id
    public Pedido findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
