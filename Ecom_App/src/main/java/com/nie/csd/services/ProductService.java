package com.nie.csd.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository repository;

    public List<Products> getAllProducts() {
        logger.info("Retrieving all products from collection");
        return repository.findAll();
    }

    public Products getProductById(String id) {
        Optional<Products> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            logger.warn("Product with ID {} not found", id);
            return null; // or throw custom exception
        }
    }

    public Products addProduct(Products product) {
        logger.info("Adding new product: {}", product.getName());
        return repository.save(product);
    }

    public Products updateProduct(String id, Products products) {
        Optional<Products> existingProductOpt = repository.findById(id);
        if (existingProductOpt.isPresent()) {
            Products existingProduct = existingProductOpt.get();
            existingProduct.setName(products.getName());
            existingProduct.setDescription(products.getDescription());
            existingProduct.setCategory(products.getCategory());
            existingProduct.setTags(products.getTags());
            existingProduct.setPrice(products.getPrice());
            existingProduct.setStock(products.getStock());
            logger.info("Updating product with ID {}", id);
            return repository.save(existingProduct);
        } else {
            logger.warn("Product with ID {} not found, cannot update", id);
            return null; // or throw custom exception
        }
    }

    public void deleteProduct(String id) {
        Optional<Products> existingProductOpt = repository.findById(id);
        if (existingProductOpt.isPresent()) {
            repository.deleteById(id);
            logger.info("Product with ID {} deleted successfully", id);
        } else {
            logger.warn("Product with ID {} not found, cannot delete", id);
        }
    }

    public Products getByProductId(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByProductId'");
    }
}
