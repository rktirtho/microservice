package com.rktirtho.inventory.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("booking-service")
public interface BookingClient {

    @GetMapping(name = "/bookings")
    String getDataFromStorageService();

}
