package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.model.Product;
import com.rik.MockProject_N1.repository.ProductRepository;
import com.rik.MockProject_N1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> fillAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> fillAllProductByCategoryIdAndPrice(Integer categoryId, Double price) {
        return productRepository.findAllByCategoryIdAndPriceGreaterThanEqual(categoryId, price);
    }

    @Override
    public List<Product> findProductByCategoryId(Integer categoryId) {
        return productRepository.findAllByCategoryIdOrderByName(categoryId);
    }

    @Override
    public List<Product> listProductByPrice() {
        return productRepository.listProductByPrice();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProductQuantity(Integer productId, Integer quantity) {
        productRepository.updateProductQuantityById(quantity, productId);
    }
}
