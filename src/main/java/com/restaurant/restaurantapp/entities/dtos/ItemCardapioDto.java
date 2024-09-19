package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.ItemCardapio;

public class ItemCardapioDto {

    private final Long id;
    private final String nome;
    private final String descricao;
    private final double preco;
    private final Cardapio cardapio;

    public ItemCardapioDto(ItemCardapio itemCardapio) {
        this.id = itemCardapio.getId();
        this.nome = itemCardapio.getNome();
        this.descricao = itemCardapio.getDescricao();
        this.preco = itemCardapio.getPreco();
        this.cardapio = itemCardapio.getCardapio();
    }
}
