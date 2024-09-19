package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.Restaurante;

import java.util.List;

public class RestauranteDto {

    private final Long id;
    private final String nome;
    private final String endereco;
    private final String telefone;
    private final List<Pedido> pedidos;
    private final List<Cardapio> cardapios;

    public RestauranteDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.endereco = restaurante.getEndereco();
        this.telefone = restaurante.getTelefone();
        this.pedidos = restaurante.getPedidos();
        this.cardapios = restaurante.getCardapios();
    }
}
