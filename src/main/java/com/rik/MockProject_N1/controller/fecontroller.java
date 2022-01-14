package com.rik.MockProject_N1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class fecontroller {
    @GetMapping("/account.html"){
    public String abc(){
        return "accout";
        }
    }
}
