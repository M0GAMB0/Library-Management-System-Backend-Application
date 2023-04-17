package com.springProjects.libararyManagementSystem.DTOs.ReqDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthorReqDto {
    String name;
    int age;
    String email;
}
