package com.restaurant.restaurantapp.service;

import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.repository.PagamentoRepository;
import com.restaurant.restaurantapp.service.exceptions.ResourceDuplicatedException;
import com.restaurant.restaurantapp.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    //Procurar por Id
    public Pagamento findById(Long id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
        return pagamento.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Criar
    public Pagamento insert(Pagamento pagamento) {
        try {
            pagamentoRepository.save(pagamento);
            return pagamento;
        } catch (DataIntegrityViolationException e) {
            throw new ResourceDuplicatedException(pagamento.getPedido().getId());
        }
    }

}
