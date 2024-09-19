package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cliente;

public class ClienteDto {

    private final Long id;
    private final String nome;
    private final String cpf;
    private final String email;
    private final String telefone;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
    }
}
