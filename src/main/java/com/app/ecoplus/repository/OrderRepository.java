package com.app.ecoplus.repository;

import com.app.ecoplus.entity.Order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);


}
