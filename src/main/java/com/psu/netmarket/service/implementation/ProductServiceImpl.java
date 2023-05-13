package com.psu.netmarket.service.implementation;

import com.psu.netmarket.model.Product;
import com.psu.netmarket.repository.ProductRepository;
import com.psu.netmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void insertProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findProductByUPC(Long upc) {
        Optional<Product> result = productRepository.findById(upc);
        Product product = null;
        if(result.isPresent()) product = result.get();
        else throw new RuntimeException("could not find product " + upc);
        return product;
    }

    @Override
    public void deleteProduct(Long upc) {
        productRepository.deleteById(upc);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
