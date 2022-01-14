package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> fillAllProduct();
    List<Product> fillAllProductByCategoryIdAndPrice(Integer categoryId, Double price);
    List<Product> findProductByCategoryId(Integer categoryId);
    List<Product> listProductByPrice();
    List<Product> getByKeyWord(String str); //X

    void addProduct(Product product);
    void deleteProduct(Integer id);
    void updateProductQuantity(Integer productId, Integer quantity);



}
