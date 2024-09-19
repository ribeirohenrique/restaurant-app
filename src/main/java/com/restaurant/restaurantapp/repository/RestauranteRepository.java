package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
