package com.rik.MockProject_N1.utils.mapping;

import com.rik.MockProject_N1.dto.UserDTO;
import com.rik.MockProject_N1.model.User;

public class MappingUtil {

    //map dữ liệu từ user qua userDTO
    public static UserDTO mapToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstname(user.getFirstname());
        userDTO.setLastname(user.getLastname());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    //map dữ liệu từ dto sang user
    public static User mapToUser(UserDTO userDTO){
        User user = new User();
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
