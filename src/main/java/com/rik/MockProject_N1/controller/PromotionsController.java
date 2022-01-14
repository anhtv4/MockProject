package com.rik.MockProject_N1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PromotionsController {
    @Autowired
    PromotionsController promotionsController;
}
