package com.example.exceptionhandling.services;

import com.example.exceptionhandling.commons.I18Constants;
import com.example.exceptionhandling.entities.Category;
import com.example.exceptionhandling.entities.Product;
import com.example.exceptionhandling.exceptions.NoSuchElementFoundException;
import com.example.exceptionhandling.models.ProductInput;
import com.example.exceptionhandling.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository repository;
    private final MessageSource messageSource;

    public Product getProduct(String id) {
        return repository.findById(id).orElseThrow(()->
                new NoSuchElementFoundException(getLocalMessage(I18Constants.NO_ITEM_FOUND.getKey(), id)));
    }

    public Product addProduct(ProductInput productInput){
        Product product = new Product();
        product.setName(productInput.getName());
        product.setPrice(productInput.getPrice());
        product.setWeight(product.getWeight());
        product.setCategory(Objects.isNull(productInput.getCategory())? Category.BOOKS: productInput.getCategory());
        return repository.save(product);
    }

    private String getLocalMessage(String key, String... params){
        return messageSource.getMessage(key,
                params,
                Locale.ENGLISH);
    }
}