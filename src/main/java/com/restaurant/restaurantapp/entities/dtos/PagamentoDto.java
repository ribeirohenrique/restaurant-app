package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.entities.Pedido;

import java.util.Date;

public class PagamentoDto {

    private final Long id;
    private final Date data;
    private final String tipoPagamento;
    private final double valor;
    private final Pedido pedido;

    public PagamentoDto(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.data = pagamento.getData();
        this.tipoPagamento = pagamento.getTipoPagamento();
        this.valor = pagamento.getValor();
        this.pedido = pagamento.getPedido();
    }
}
