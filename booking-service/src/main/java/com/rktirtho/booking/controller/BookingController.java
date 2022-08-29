package com.rktirtho.booking.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rktirtho.booking.client.StorageClient;
import com.rktirtho.booking.entity.Order;
import com.rktirtho.booking.model.OrderRequest;
import com.rktirtho.booking.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private StorageClient storageClient;
    private OrderRepository repository;

    public BookingController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallBackForStckAPI")
    public String submitOrder(@RequestBody OrderRequest orderRequest) {

        boolean inStock = orderRequest.getOrderItems()
                .stream()
                .allMatch(orderItem -> storageClient.stockCheck(orderItem.getCode()));

        if (inStock) {

            Order request = new Order();
            request.setOrderNo(UUID.randomUUID().toString());
            request.setOrderItems(orderRequest.getOrderItems());
            repository.save(request);
            return "Order placed";
        } else
            return "Product is not in stock";
    }

    @GetMapping("/{code}")
    public boolean showProduct(@PathVariable String code) {

        return storageClient.stockCheck(code);

    }

    @GetMapping("/test")
    public boolean Test() {
        return true;

    }

    private String fallBackForStckAPI(){
        return "Data fetch failed";
    }

}
