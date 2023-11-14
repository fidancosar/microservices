package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.dtos.responses.SubmitOrderResponse;

import java.util.List;

public interface OrderService {
    Boolean submitOrders(List<CreateOrderRequest> requests);
    List<SubmitOrderResponse> submitOrder(List<CreateOrderRequest> requests);
}
