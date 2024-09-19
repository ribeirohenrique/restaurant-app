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
    private final EnderecoRestaurante endereco;
    private final String telefone;

    public RestauranteDto(Restaurante restaurante) {
        this.id = restaurante.getId();
        this.nome = restaurante.getNome();
        this.endereco = restaurante.getEnderecoRestaurante();
        this.telefone = restaurante.getTelefone();
    }
}
