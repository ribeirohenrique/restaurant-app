package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.Pedido;
import com.restaurant.restaurantapp.entities.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class RestauranteDto {

    private final Long id;
    private final String nome;
    private final String telefone;
    private final EnderecoRestaurante enderecoRestaurante;
    private List<Pedido> pedidos;
    private Cardapio cardapio;


    public RestauranteDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.telefone = restaurante.getTelefone();
        this.pedidos = restaurante.getPedidos();
        this.cardapio = restaurante.getCardapio();
        this.enderecoRestaurante = restaurante.getEnderecoRestaurante();
    }
}
