package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.model.Promotions;
import com.rik.MockProject_N1.service.PromotionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PromotionsController {
    @Autowired
    private PromotionsService promotionsService;
    // api show list danh sách tỏng db
    @GetMapping("/showPromotions")
    public String showPromotions(Model model){
        List<Promotions> promotionslist = promotionsService.fillAllPromotions();
        model.addAttribute("promotionslist" , promotionslist );
        return "ShowPromotions";
    }
    // trang nhập dữ liệu thêm promotions
    @GetMapping("/")
    public String view(Model model){
        Promotions promotions = new Promotions();
        model.addAttribute("promotions", promotions);
        return "savePromotions";
    }
    // api lưu
    @RequestMapping("/savePromotions")
    public void savePromotions(@ModelAttribute("promotions") Promotions promotions){
        promotionsService.addPromotions(promotions);
    }

    // xoá
//    @DeleteMapping("/deletePromotions")
//    public void
}
