package com.springProjects.libararyManagementSystem.DTOs.ResDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResDto {
    String name;
    int age;
    String email;
}
