package com.rktirtho.inventory.service;

import com.rktirtho.inventory.entity.ProductEntity;
import com.rktirtho.inventory.model.ProductRegistrationRequest;

import java.util.List;

public interface ProductService {
    ProductEntity saveProduct(ProductRegistrationRequest request);

    List<ProductEntity> getAllProduct();
}
