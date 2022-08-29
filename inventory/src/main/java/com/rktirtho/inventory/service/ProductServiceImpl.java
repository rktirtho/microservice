package com.rktirtho.inventory.service;


import com.rktirtho.inventory.entity.ProductEntity;
import com.rktirtho.inventory.model.ProductRegistrationRequest;
import com.rktirtho.inventory.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductEntity saveProduct(ProductRegistrationRequest request) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(request, entity);
        return repository.save(entity);
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return repository.findAll();
    }
}
