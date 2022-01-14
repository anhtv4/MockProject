package com.rik.MockProject_N1.service;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;
import com.rik.MockProject_N1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Integer id);
    boolean saveUser(UserDTO userDTO);
    User findByUsernameAndPassword(String username, String password);

    void deleteUserAdmin(Integer id);
    void newUserAdmin(User user);
    void editUserAdmin(User user);

}
