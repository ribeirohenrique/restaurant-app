package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PedidoDto {
    private final Long id;
    private final Date data;
    private final String status;
    private final double total;

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.data = pedido.getData();
        this.status = pedido.getStatus();
        this.total = pedido.getTotal();
    }
}
