package com.rktirtho.inventory.controller;

import com.rktirtho.inventory.clients.BookingClient;
import com.rktirtho.inventory.entity.ProductEntity;
import com.rktirtho.inventory.model.ProductRegistrationRequest;
import com.rktirtho.inventory.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService service;
    private final BookingClient bookingClient;

    public ProductController(ProductService service, BookingClient bookingClient) {
        this.service = service;
        this.bookingClient = bookingClient;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductEntity> saveProduct(@RequestBody ProductRegistrationRequest request) {
        return new ResponseEntity<>(service.saveProduct(request), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        return new ResponseEntity<>(service.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("prop")
    public String getProperties (){
        return bookingClient.getDataFromStorageService();
    }

}
