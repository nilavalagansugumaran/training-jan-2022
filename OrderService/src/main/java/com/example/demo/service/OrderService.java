package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {

    @Autowired private OrderRepository orderRepository;

    public Order getOrder(Long id){
        Order order = orderRepository.findById(id).orElse(null);
        if(order== null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        return order;
    }

    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}
