package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.model.Categories;
import com.rik.MockProject_N1.service.impl.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoriesController {

    @Autowired
    CategoriesServiceImpl categoriesService;

    @GetMapping("/category")
    public ResponseEntity<List<Categories>> getAllProduct(){
        List<Categories> categoriesList = new ArrayList<>();
        categoriesList = categoriesService.findAllCategories();
        return new ResponseEntity<List<Categories>>(categoriesList, HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<String> addProduct(@RequestBody Categories categories){
        categoriesService.addCategory(categories);
        return new ResponseEntity<String>("category add oki", HttpStatus.OK);
    }

    @DeleteMapping("/category")
    public ResponseEntity<String> deleteProduct(@RequestParam Integer id){
        categoriesService.deleteCategory(id);
        return new ResponseEntity<String>("category: "+ id + " delete oki", HttpStatus.OK);
    }
    @PutMapping("/category")
    public ResponseEntity<String> deleteProduct(@RequestParam String str, Integer id){

        categoriesService.updateCategory(str, id);
        return new ResponseEntity<String>("product name add: "+ str + " oki", HttpStatus.OK);
    }
}
