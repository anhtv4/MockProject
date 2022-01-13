package com.rik.MockProject_N1.controller;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping(value = {"/users"})
    public ResponseEntity<List<User>> getAllUser(){
        List<User> userList = new ArrayList<>();
        userList = userService.fillAllUser();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<String>("User added successful",HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<String> deleletUser(@RequestParam Integer id){
        userService.deleteUser(id);
        return new ResponseEntity<String>("Delete user "+ id +" successful",HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<String> updateNameUser(@RequestParam String str, Integer id){
        userService.updateUser(str,id);
        return new ResponseEntity<String>("Add user by name successful",HttpStatus.OK);
    }


}
