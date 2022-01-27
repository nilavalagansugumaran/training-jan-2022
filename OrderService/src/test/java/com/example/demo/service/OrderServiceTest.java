package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired OrderService orderService;

    @MockBean
    OrderRepository orderRepository;

    @Test
    void return_order_successfully_when_found_in_repository(){
        // set-up
        Mockito.when(orderRepository.findById(Mockito.any())).thenReturn(Optional.of(new Order()));

        // test
        Order orderFromDB = orderService.getOrder(101l);

        //verify results
        assertTrue(orderFromDB !=null);
        Mockito.verify(orderRepository,Mockito.atMostOnce()).findById(Mockito.any());
    }

    @Test
    void return_error_when_order_not_found_in_repository(){
        // set-up
        Mockito.when(orderRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        // test
        assertThrows(ResponseStatusException.class, () -> {
            orderService.getOrder(101l);
        });

        //verify results
        Mockito.verify(orderRepository,Mockito.atMostOnce()).findById(Mockito.any());
    }

    @Test
    void create_order_in_repository_successfully(){
        // set-up
        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenReturn(new Order());

        // test
        Order order = orderService.createOrder(new Order());

        //verify results
        assertTrue(order !=null);
        Mockito.verify(orderRepository,Mockito.atMostOnce()).save(Mockito.any(Order.class));
    }

}