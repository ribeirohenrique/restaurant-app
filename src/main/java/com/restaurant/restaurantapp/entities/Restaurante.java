package com.restaurant.restaurantapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String telefone;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurante")
    private List<Pedido> pedidos;

    @JsonIgnore
    @OneToOne(mappedBy = "restaurante")
    private Cardapio cardapio;

    @JsonIgnore
    @OneToOne
    private EnderecoRestaurante enderecoRestaurante;
}
