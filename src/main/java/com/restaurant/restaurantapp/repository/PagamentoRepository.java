package com.restaurant.restaurantapp.repository;

import com.restaurant.restaurantapp.entities.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
