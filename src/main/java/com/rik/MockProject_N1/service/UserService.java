package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;

import java.util.List;

public interface UserService {
    List<User> fillAllUser();
    void addUser(User user);
    void deleteUser(Integer id);
    void updateUser(String str, Integer id);
//    List<UserDTO> mostOrder();
}
