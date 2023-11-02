package com.turkcell.orderservice.services;

import com.turkcell.orderservice.dtos.requests.CreateOrderRequest;
import com.turkcell.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService{
    private final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;


    @Override
    public Boolean submitOrders(List<CreateOrderRequest> requests) {
        for (CreateOrderRequest request : requests){
            Boolean hasStock = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8083/api/v1/products/check-stock",
                            (uriBuilder) -> uriBuilder
                                    .queryParam("invCode", request.getInventoryCode())
                                    .queryParam("requiredStock", request.getStockAmount())
                                    .build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
            if (!hasStock) {

                return false;
            }
        }
        return true;
    }
}
