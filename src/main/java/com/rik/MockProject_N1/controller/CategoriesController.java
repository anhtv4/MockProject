package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.model.Categories;
import com.rik.MockProject_N1.service.impl.CategoriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class CategoriesController {

    @Autowired
    CategoriesServiceImpl categoriesService;

    @GetMapping("/category")
    public String getAllCate(Model model){
        List<Categories> categoriesList = categoriesService.findAllCategories();
        model.addAttribute("categoriesList", categoriesList);
        return "index";
    }

    @GetMapping("/add_category")
    public String newCate(Model model){
        Categories categories = new Categories();
        model.addAttribute("categories", categories);
        return "newcategory";
    }

    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("categories") Categories categories) {
        categoriesService.addCategory(categories);
        return "redirect:/category";
    }


//    @PostMapping("/category")
//    public ResponseEntity<String> addProduct(@RequestBody Categories categories){
//        categoriesService.addCategory(categories);
//        return new ResponseEntity<String>("category add oki", HttpStatus.OK);
//    }

//    @DeleteMapping("/category/delete")
//    public void deleteProduct(@RequestParam Integer id){
//        categoriesService.deleteCategory(id);
////        return new ResponseEntity<String>("category: "+ id + " delete oki", HttpStatus.OK);
//    }
@RequestMapping("/delete/{id}")
public String deleteCate(@PathVariable(name = "id") int id) {
    categoriesService.deleteCategory(id);
    return "redirect:/category";
}

    @RequestMapping("/edit/{id}")
    public ModelAndView updateCate(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit");
        Categories categories = categoriesService.get(id);
        mav.addObject("categories", categories);
        return mav;
    }

}
