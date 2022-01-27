package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.security.web.header.Header;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerIT {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    OrderRepository orderRepository;

    @Test
    void admin_user_should_create_order_successfully(){
        // pre-check
        assertTrue(orderRepository.count() == 0);

        // set-up
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic YWRtaW46YWRtaW4=");
        HttpEntity entity = new HttpEntity("{\n" +
                "\"items\": \"new gold pen1\",\n" +
                "\"price\": 2000,\n" +
                "\"phoneNumber\": \"1234567890\"\n" +
                "}", headers);

        // test
        ResponseEntity<Order> responseEntity = testRestTemplate.exchange(
                "/order", HttpMethod.POST,entity, Order.class);

        //verify results
        assertTrue(responseEntity.getStatusCode() == HttpStatus.OK);
        assertTrue(responseEntity.getBody().getId() == 1);
        assertTrue(orderRepository.count() == 1);
    }

    @Test
    void order_creation_should_fail_for_invalid_request(){
        // pre-check
        orderRepository.deleteAll();
        assertTrue(orderRepository.count() == 0);

        // set-up
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic YWRtaW46YWRtaW4=");
        HttpEntity entity = new HttpEntity("{\n" +
                "\"items\": \"new gold pen1\",\n" +
                "\"price\": 2000,\n" +
                "\"phoneNumber\": \"123\"\n" +
                "}", headers);

        // test
        ResponseEntity<Order> responseEntity = testRestTemplate.exchange(
                "/order", HttpMethod.POST,entity, Order.class);

        //verify results
        assertTrue(responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST);
        assertTrue(orderRepository.count() == 0);
    }

    @Test
    void non_admin_user_should_be_denied_creating_order(){
        // pre-check
        orderRepository.deleteAll();
        assertTrue(orderRepository.count() == 0);

        // set-up
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "application/json");
        headers.add("Authorization", "Basic bmlsYTpwYXNzd29yZA==");
        HttpEntity entity = new HttpEntity("{\n" +
                "\"items\": \"new gold pen1\",\n" +
                "\"price\": 2000,\n" +
                "\"phoneNumber\": \"1234567890\"\n" +
                "}", headers);

        // test
        ResponseEntity<Order> responseEntity = testRestTemplate.exchange(
                "/order", HttpMethod.POST,entity, Order.class);

        //verify results
        assertTrue(responseEntity.getStatusCode() == HttpStatus.FORBIDDEN);
        assertTrue(orderRepository.count() == 0);
    }
}