package com.restaurant.restaurantapp.entities.dtos;


import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import com.restaurant.restaurantapp.entities.ItemCardapio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EnderecoRestauranteDto {
    private Long id;
    private String endereco;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;

    public EnderecoRestauranteDto(EnderecoRestaurante enderecoRestaurante) {
        this.id = enderecoRestaurante.getId();
        this.endereco = enderecoRestaurante.getEndereco();
        this.numero = enderecoRestaurante.getNumero();
        this.cep = enderecoRestaurante.getCep();
        this.bairro = enderecoRestaurante.getBairro();
        this.cidade = enderecoRestaurante.getCidade();
    }
}
