package com.example.mongodb.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String teamName;
    private String departmentId;
}
