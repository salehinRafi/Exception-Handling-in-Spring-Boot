package com.example.exceptionhandling.controllers;

import com.example.exceptionhandling.entities.Product;
import com.example.exceptionhandling.models.ProductInput;
import com.example.exceptionhandling.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j(topic = "PRODUCT_CONTROLLER")
@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Product getProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody @Valid ProductInput input) {
        return productService.addProduct(input);
    }
}
