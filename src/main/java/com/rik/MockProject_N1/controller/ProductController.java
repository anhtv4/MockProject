package com.rik.MockProject_N1.controller;


import com.rik.MockProject_N1.model.Product;
import com.rik.MockProject_N1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @GetMapping("/list_all")
    public ResponseEntity<List<Product>> getAllProduct(Model model) {
        List<Product> productList = new ArrayList<>();
        productList = productService.fillAllProduct();
        model.addAttribute("productsList",productList);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    @GetMapping("/get_by_id_and_price")
    public ResponseEntity<List<Product>> getAllProductByCategoryIdAndPrice(@RequestParam Integer categoryId, @RequestParam Double price) {
        List<Product> productList = productService.fillAllProductByCategoryIdAndPrice(categoryId, price);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
    }

    @GetMapping("/list_product_by_category")
    public ResponseEntity<List<Product>> getAllProductByCategory(@RequestParam Integer categoryId){
        List<Product> lisByCategoryId = productService.findProductByCategoryId(categoryId);
        return new ResponseEntity<>(lisByCategoryId, HttpStatus.OK);
    }

    @GetMapping("/list_product_by_price")
    public ResponseEntity<List<Product>> getAllProductByPrice(){
        List<Product> lisByPrice = productService.listProductByPrice();
        return new ResponseEntity<>(lisByPrice, HttpStatus.OK);
    }

    @DeleteMapping("/delete_by_id")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id) {

        productService.deleteProduct(id);
        return new ResponseEntity<String>("product: " + id + " delete oki", HttpStatus.OK);
    }

    @PutMapping("/update_quantity")
    public ResponseEntity<String> modifyProductQuantity(@RequestParam Integer id, @RequestParam Integer quantity) {

        productService.updateProductQuantity(id, quantity);
        return new ResponseEntity<String>("update quantiry for product: " + id + " oki", HttpStatus.OK);
    }

    @PostMapping("/add_product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<String>("product add oki", HttpStatus.OK);
    }

    //X
    @GetMapping("/search")
    public String findProductByName(Product product, Model model, String str){
        if(str != null ){
            List<Product> listPr = productService.getByKeyWord(str);
            model.addAttribute("list", listPr);
        }
        else{
            List<Product> listPr = productService.fillAllProduct();
            model.addAttribute("list", listPr);
        }
        return "find-product";
    }


}
