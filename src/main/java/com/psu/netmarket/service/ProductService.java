package com.psu.netmarket.service;

import com.psu.netmarket.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void insertProduct(Product product);
    List<Product> findAllProducts();
    Product findProductByUPC(Long upc);
    void deleteProduct(Long upc);
    void deleteAllProducts();
}
