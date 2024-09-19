package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.*;

import java.util.Date;
import java.util.List;

public class PedidoDto {
    private final Long id;
    private final Date data;
    private final String status;
    private final double total;
    private final Cliente cliente;
    private final List<ItemCardapio> itens;
    private final Pagamento pagamento;
    private final Restaurante restaurante;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.status = pedido.getStatus();
        this.total = pedido.getTotal();
        this.cliente = pedido.getCliente();
        this.itens = pedido.getItens();
        this.pagamento = pedido.getPagamento();
        this.restaurante = pedido.getRestaurante();
    }
}
