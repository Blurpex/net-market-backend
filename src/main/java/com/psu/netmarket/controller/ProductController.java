package com.psu.netmarket.controller;

import com.psu.netmarket.exception.NotFoundException;
import com.psu.netmarket.model.Product;
import com.psu.netmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/upc/{upc}")
    public Product getProductByUPC(@PathVariable Long upc) {
        Product product = productService.findProductByUPC(upc);
        if(product == null)
            throw new NotFoundException("product " + upc + " not found");
        return product;
    }

    @PostMapping("/post/product")
    public void insertProduct(@RequestBody Product product) {
        productService.insertProduct(product);
    }

    @DeleteMapping("/delete/{upc}")
    public void deleteProduct(@PathVariable Long upc) {
        productService.deleteProduct(upc);
    }

}
