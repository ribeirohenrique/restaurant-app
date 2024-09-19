package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Cardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {
}
