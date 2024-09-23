package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.repository.PedidoRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    //Procurar por Id
    public Pedido findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public Pedido insert(Pedido pedido) {
        try {
            pedidoRepository.save(pedido);
            return pedido;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(pedido.getId());
        }
    }
}
