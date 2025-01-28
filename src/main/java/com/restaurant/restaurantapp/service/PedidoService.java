package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.repository.PedidoRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    // Procurar por Id
    public Pedido findById(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }

    // Criar
    public Pedido insert(Pedido pedido) {
        try {
            pedidoRepository.save(pedido);
            return pedido;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(pedido.getId());
        }
    }

    // Atualizar
    public Pedido update(Long id, Pedido pedido) {
        try {
            Pedido existingPedido = findById(id);
            existingPedido.setData(pedido.getData());
            existingPedido.setStatus(pedido.getStatus());
            existingPedido.setTotal(pedido.getTotal());
            existingPedido.setCliente(pedido.getCliente());
            existingPedido.setItens(pedido.getItens());
            existingPedido.setPagamento(pedido.getPagamento());
            existingPedido.setRestaurante(pedido.getRestaurante());
            return pedidoRepository.save(existingPedido);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            Pedido pedido = findById(id);
            pedidoRepository.delete(pedido);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
