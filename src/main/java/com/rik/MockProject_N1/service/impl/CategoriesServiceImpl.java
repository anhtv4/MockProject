package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.model.Categories;
import com.rik.MockProject_N1.repository.CategoriesRepository;
import com.rik.MockProject_N1.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Override
    public List<Categories> findAllCategories() {
        return categoriesRepository.findAll();
    }

    @Override
    public void addCategory(Categories categories) {
        categoriesRepository.save(categories);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoriesRepository.deleteById(id);
    }

    @Override
    public Categories get(Integer id) {
        return categoriesRepository.findById(id).get();
    }

    @Override
    public void updateCategory(String str, Integer id) {
//        categoriesRepository.updateCategory(str, id);
    }
}
