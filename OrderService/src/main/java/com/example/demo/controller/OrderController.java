package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired private OrderService orderService;

    @GetMapping(path = "/order/{id}", headers = {"Accept=application/json","Content-Type=application/json"})
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @PostMapping(path = "/order", headers = {"Accept=application/json","Content-Type=application/json"})
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
