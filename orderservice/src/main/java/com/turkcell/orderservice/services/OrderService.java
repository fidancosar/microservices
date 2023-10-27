package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;

import java.util.List;

public interface OrderService {
    Boolean submitOrders(List<CreateOrderRequest> requests);
}
