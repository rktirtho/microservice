package com.rktirtho.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// eureka service name
@FeignClient(name = "storage-service")
public interface StorageClient {

//    @RequestMapping(value = "/storages/{productCode}")
    @GetMapping(value = "/storages/{productCode}")
    boolean stockCheck(@PathVariable String productCode);
}
