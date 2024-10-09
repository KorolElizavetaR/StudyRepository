package com.mockito.junit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockito.junit.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}