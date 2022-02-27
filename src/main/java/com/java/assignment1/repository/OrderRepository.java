package com.java.assignment1.repository;

import com.java.assignment1.modle.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrdersEntity, Integer> {
}
