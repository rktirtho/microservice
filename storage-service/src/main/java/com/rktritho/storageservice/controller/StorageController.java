package com.rktritho.storageservice.controller;

import com.rktritho.storageservice.entity.StockEntity;
import com.rktritho.storageservice.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/storages")
public class StorageController {

    private final StockRepository repository;

    public StorageController(StockRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{productCode}")
    public boolean stockAvailable(@PathVariable String productCode) {

        Optional<StockEntity> stock = repository.findByCode(productCode);
        if (!stock.isPresent()){
            return false;
        }

        return stock.get().getQuantity() > 0;
    }
}
