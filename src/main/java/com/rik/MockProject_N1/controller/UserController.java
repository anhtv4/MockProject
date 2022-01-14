package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.dto.LoginUser;
import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @GetMapping(value = "/admin/users")
    public String viewUserPage(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "admin/users";
    }

    @GetMapping(value = "/admin/edit_user/{id}")
    public ModelAndView editUserAdminPage(@PathVariable(name = "id") Integer id) {
        ModelAndView mav = new ModelAndView("admin/edit_user");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    //Sửa user phía admin
    @PostMapping("/editUserAdmin")
    public String editUserAdmin(@ModelAttribute("user") User user) {
        userService.editUserAdmin(user);
        return "redirect:/admin/users";
    }

    //xóa user phía admin
    @GetMapping (value = "/admin/delete/{id}")
    public String deleteUserAdmin(@PathVariable(name = "id") Integer id) {
        userService.deleteUserAdmin(id);
        return "redirect:/admin/users";
    }

    //thêm mới user
    @GetMapping("/admin/add_user")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin/add_user";
    }

    //thêm mới user từ phía admin vào db và điều hướng đến userList
    @PostMapping(value = "newUser")
    public String newUser(@ModelAttribute("user") User user){
        userService.newUserAdmin(user);
        return "redirect:admin/users";
    }
}