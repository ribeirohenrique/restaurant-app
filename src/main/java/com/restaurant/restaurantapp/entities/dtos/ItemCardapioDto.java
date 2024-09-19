package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemCardapioDto {

    private final Long id;
    private final String nome;
    private final String descricao;
    private final double preco;

    public ItemCardapioDto(ItemCardapio itemCardapio) {
        this.id = itemCardapio.getId();
        this.nome = itemCardapio.getNome();
        this.descricao = itemCardapio.getDescricao();
        this.preco = itemCardapio.getPreco();
    }
}
