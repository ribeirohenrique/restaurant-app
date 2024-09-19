package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Cardapio;
import com.restaurant.restaurantapp.entities.EnderecoRestaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRestauranteRepository extends JpaRepository<EnderecoRestaurante, Long> {
}
