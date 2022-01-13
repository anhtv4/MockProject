package com.rik.MockProject_N1.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class UserDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
}
