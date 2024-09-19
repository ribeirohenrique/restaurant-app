package com.restaurant.restaurantapp.entities.dtos;

import com.restaurant.restaurantapp.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDto {

    private final Long id;
    private final String nome;
    private final String cpf;
    private final String email;

    public ClienteDto(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
    }
}
