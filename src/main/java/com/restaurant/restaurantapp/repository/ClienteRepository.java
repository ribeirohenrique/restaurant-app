package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
