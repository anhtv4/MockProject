package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.dto.LoginUser;
import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    //tạo đường dẫn mặc định cho home
    @GetMapping("/home")
    public String viewHomePage() {
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") UserDTO userDTO, Model model) {
        userService.saveUser(userDTO);
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        LoginUser loginUser = new LoginUser();
        model.addAttribute("userLogin", loginUser);
        return "account";
    }

    @GetMapping("/login")
    public String login(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        LoginUser loginUser = new LoginUser();
        model.addAttribute("userLogin", loginUser);
        return "account";
    }

    @PostMapping("/login")
    public String loginWeb(@ModelAttribute("userLogin") LoginUser loginUser, HttpServletRequest request) {
        User user = userService.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
        HttpSession httpSession = request.getSession();
        if (user != null) {
            httpSession.setAttribute("login", user);
            return "redirect:home";
        }
        return "account";
    }


}
