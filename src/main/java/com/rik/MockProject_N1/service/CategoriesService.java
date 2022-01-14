package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.model.Categories;

import java.util.List;

public interface CategoriesService {

    List<Categories> findAllCategories();
    void addCategory( Categories categories);

    void deleteCategory(Integer id);

    Categories get(Integer id);

    void updateCategory(String str, Integer id);
}
