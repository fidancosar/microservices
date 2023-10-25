package com.turkcell.productservice.services;

import com.turkcell.productservice.dto.requests.CreateProductRequest;

public interface ProductService {
    CreateProductRequest add(CreateProductRequest request);
}
