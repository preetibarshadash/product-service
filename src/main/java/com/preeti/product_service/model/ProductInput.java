package com.preeti.product_service.model;

import lombok.Data;

@Data
public class ProductInput {
    private String id;

    private String name;

    private String description;

    private double price;

    private int stock;
}
