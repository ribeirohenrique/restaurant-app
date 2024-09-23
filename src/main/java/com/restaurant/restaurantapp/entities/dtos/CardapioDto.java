package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import com.restaurant.restaurantapp.entities.Restaurante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CardapioDto {

    private final Long id;
    private final String nome;
    private final Restaurante restaurante;
    private final List<ItemCardapio> itens;

    public CardapioDto(Cardapio cardapio) {
        this.id = cardapio.getId();
        this.nome = cardapio.getNome();
        this.restaurante = cardapio.getRestaurante();
        this.itens = cardapio.getItens();
    }
}
