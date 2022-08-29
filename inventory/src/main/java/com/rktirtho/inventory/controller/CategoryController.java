package com.rktirtho.inventory.controller;

import com.rktirtho.inventory.clients.BookingClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
@Getter
@Setter
@RefreshScope // This will refresh all the value data in the bean when actuator refresh will be call
public class CategoryController {

    @Value("${app.prop1}")
    private String prop1;

    private final BookingClient bookingClient;

    public CategoryController(BookingClient bookingClient) {
        this.bookingClient = bookingClient;
    }

    @GetMapping("prop")
    public String getProperties (){
    return prop1 + bookingClient.getDataFromStorageService();
    }

}
