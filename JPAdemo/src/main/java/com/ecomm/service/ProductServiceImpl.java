/*
 * Author : Ketki Keni
 * Date : 25-01-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.ecomm.service;

import com.ecomm.domain.Product;
import com.ecomm.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    ProductRepo productRepo;
    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList=new ArrayList<Product>();
        productRepo.findAll().forEach(productList::add);
        return productList;
    }

    @Override
    public List<Product> getProductById(int productId) {
        return productRepo.findById(productId);
    }

    @Override
    public boolean deleteProduct(int productId) {
        productRepo.deleteById(productId);
        return true;
    }
}
