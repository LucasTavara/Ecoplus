package com.app.ecoplus.repository;

import com.app.ecoplus.entity.Order.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);
    @Query(
            value = "SELECT * FROM orders o WHERE o.user_ref = ?1",
            nativeQuery = true)
    List<Order> findByUserRef(Long userRef);


}
