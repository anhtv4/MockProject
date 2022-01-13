package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.repository.UserRepository;
import com.rik.MockProject_N1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> fillAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(String str, Integer id) {
        userRepository.updateNameUser(str,id);
    }

//    @Override
//    public List<UserDTO> mostOrder() {
//        return userRepository.mostOrder();
//    }
}
