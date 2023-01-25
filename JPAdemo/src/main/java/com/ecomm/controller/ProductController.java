/*
 * Author : Ketki Keni
 * Date : 25-01-2023
 * Created with : IntelliJ IDEA Community Edition
 */

package com.ecomm.controller;

import com.ecomm.domain.Product;
import com.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Uri : http://localhost:8082/api/v1/product : Method : Post
    @PostMapping("/product")
    public ResponseEntity<?> insertProduct(@RequestBody Product product){
        System.out.println(product);
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }

    //Uri : http://localhost:8082/api/v1/products : Method : Get
    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.OK);
    }

    //Uri : http://localhost:8082/api/v1/product/103 : Method : Delete
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        if(productService.deleteProduct(id)) {
            return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<String>("Error Occurred",HttpStatus.NOT_FOUND);
        }
    }
}
