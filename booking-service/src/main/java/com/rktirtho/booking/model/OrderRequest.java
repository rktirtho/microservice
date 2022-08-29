package com.rktirtho.booking.model;

import com.rktirtho.booking.entity.OrderItem;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequest {
    private List<OrderItem> orderItems;
}
