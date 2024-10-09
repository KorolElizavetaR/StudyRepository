package com.mockito.junit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockito.junit.exception.OrderNotFoundException;
import com.mockito.junit.model.Order;
import com.mockito.junit.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional (readOnly = true)
public class OrderService {
    private OrderRepository orderRepository;

    @Transactional (readOnly = false)
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException());
    }

    @Transactional (readOnly = false)
    public void deleteOrder(int orderId) {
        orderRepository.delete(orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException()));
    }
    
    @Transactional (readOnly = false)
    public Order updateOrder(Order newOrder, int orderId)
    {
    	orderRepository.findById(orderId).orElseThrow(()-> new OrderNotFoundException());
    	newOrder.setOrderId(orderId);
    	return orderRepository.save(newOrder);
    }
}