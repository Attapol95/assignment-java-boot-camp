package com.java.assignment1.repository;

import com.java.assignment1.modle.entity.ShippingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddressEntity, Integer> {
}
