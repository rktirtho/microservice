package com.rktirtho.inventory.model;

import lombok.Data;

@Data
public class ProductRegistrationRequest {
    private String name;
    private String description;
    private double unitPrice;
}
