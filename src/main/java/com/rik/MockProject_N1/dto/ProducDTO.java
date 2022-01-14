package com.rik.MockProject_N1.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class ProducDTO {

    private int id;
    private String name;
    private String descriptions;
    private double price;
    private int quantity;


}
