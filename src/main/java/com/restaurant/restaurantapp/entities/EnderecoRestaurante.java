package com.restaurant.restaurantapp.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco_restaurante")
public class EnderecoRestaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;

    @JsonIgnore
    @OneToOne
    private Restaurante restaurante;

}
