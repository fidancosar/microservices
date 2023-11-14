package com.turkcell.orderservice.controllers;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.dtos.responses.SubmitOrderResponse;
import com.turkcell.orderservice.services.OrderService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.*;


import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

@RequestMapping("api/v1/orders")
@RestController
@RequiredArgsConstructor
public class OrdersController {
    private final OrderService orderService;


    @PostMapping("/submit-order")
    @CircuitBreaker
    public List<SubmitOrderResponse> submitOrder(@RequestBody List<CreateOrderRequest> requests) {
        return orderService.submitOrder(requests);
    }

    private List<SubmitOrderResponse> fallbackSubmitOrder(Exception e) {

        return Collections.emptyList();
    }
}