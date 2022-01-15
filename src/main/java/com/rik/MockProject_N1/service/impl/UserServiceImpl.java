package com.rik.MockProject_N1.service.impl;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.repository.UserRepository;
import com.rik.MockProject_N1.service.UserService;
import com.rik.MockProject_N1.utils.mapping.MappingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserAdmin(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public boolean saveUser(UserDTO userDTO) {
        User user = MappingUtil.mapToUser(userDTO);
        if (userRepository.findByUsernameOrPhoneOrEmail(user.getUsername(), user.getPhone(), user.getEmail()).isEmpty()){
            user.setRole_id(1);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).get();
    }

    @Override
    public void newUserAdmin(User user) {
        if(userRepository.findByUsernameOrPhoneOrEmail(user.getUsername(), user.getPhone(), user.getEmail()).isEmpty()){
            userRepository.save(user);
        }
    }

    @Override
    public void editUserAdmin(User user) {
        userRepository.save(user);
    }

}
