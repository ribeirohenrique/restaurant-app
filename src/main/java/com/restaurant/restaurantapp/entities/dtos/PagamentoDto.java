package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Pagamento;
import com.restaurant.restaurantapp.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class PagamentoDto {

    private final Long id;
    private final Date data;
    private final String tipoPagamento;
    private final double valor;

    public PagamentoDto(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.data = pagamento.getData();
        this.tipoPagamento = pagamento.getTipoPagamento();
        this.valor = pagamento.getValor();
    }
}
