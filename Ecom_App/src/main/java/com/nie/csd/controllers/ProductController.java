package com.nie.csd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nie.csd.models.Products;
import com.nie.csd.services.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    // retrive all products

  @GetMapping("/hello")
    public String sayhello(){
        return "hello" ;
    }

    @GetMapping("/products")
    public List<Products> getAllProducts() {
        return service.getAllProducts();
    }

    // retrive product by id
    @GetMapping("/products/{id}")
    public Products getByProductId(@PathVariable("id") String id) {
        return service.getByProductId(id);
    }

    // add new product
    @PostMapping("/Products")
    public Products addProduct(@RequestBody Products products) {
        // TODO: process POST request

        return service.addProduct(products);
    }

    // update product by is
    @PutMapping("products/{id}")
    public String putMethodName(@PathVariable String id, @RequestBody String entity) {

        return entity;
    }

    public Products updateProduct(@PathVariable("id") String id, @RequestBody Products products) {
        return service.updateProduct(id, products);
    }

    // delete product by id
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);

    }

}
