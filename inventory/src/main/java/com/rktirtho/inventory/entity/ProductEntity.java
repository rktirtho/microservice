package com.rktirtho.inventory.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(value = "product")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private double unitPrice;

}
