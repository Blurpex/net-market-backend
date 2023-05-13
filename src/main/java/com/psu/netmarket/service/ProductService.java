package com.psu.netmarket.service;

import com.psu.netmarket.model.Product;

import java.util.List;

public interface ProductService {
    void insertProduct(Product product);
    List<Product> findAllProducts();
    Product findProductByUPC(Long upc);
    void deleteProduct(Long upc);
    void deleteAllProducts();
}
