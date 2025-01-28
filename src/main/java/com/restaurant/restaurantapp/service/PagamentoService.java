package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.repository.PagamentoRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Procurar por Id
    public Pagamento findById(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    // Procurar todos
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

    // Criar
    public Pagamento insert(Pagamento pagamento) {
        try {
            pagamentoRepository.save(pagamento);
            return pagamento;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(pagamento.getPedido().getId());
        }
    }

    // Atualizar
    public Pagamento update(Long id, Pagamento pagamento) {
        try {
            Pagamento existingPagamento = findById(id);
            existingPagamento.setData(pagamento.getData());
            existingPagamento.setTipoPagamento(pagamento.getTipoPagamento());
            existingPagamento.setValor(pagamento.getValor());
            existingPagamento.setPedido(pagamento.getPedido());
            return pagamentoRepository.save(existingPagamento);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    // Deletar
    public void delete(Long id) {
        try {
            Pagamento pagamento = findById(id);
            pagamentoRepository.delete(pagamento);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }
}
