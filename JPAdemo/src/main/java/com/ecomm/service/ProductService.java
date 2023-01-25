package com.ecomm.service;

import com.ecomm.domain.Product;

import java.util.List;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> getAllProducts();
    public List<Product> getProductById(int productId);
    public boolean deleteProduct(int productId);
}
