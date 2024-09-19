package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
