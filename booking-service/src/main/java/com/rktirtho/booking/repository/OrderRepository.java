package com.rktirtho.booking.repository;

import com.rktirtho.booking.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
