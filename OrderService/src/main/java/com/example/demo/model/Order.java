package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Table(name = "Orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "items can not be blank")
    private String items;

    @Min(value = 200, message = "minimum price should be 200")
    @Max(value = 3000, message = "max price is 3000")
    private Double price;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + id +
                ", items='" + items + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order() {
    }

    public Order(Long id, String items, Double price) {
        this.id = id;
        this.items = items;
        this.price = price;
    }
}
