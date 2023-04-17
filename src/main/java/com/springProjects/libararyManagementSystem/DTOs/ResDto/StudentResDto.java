package com.springProjects.libararyManagementSystem.DTOs.ResDto;

import com.springProjects.libararyManagementSystem.enums.Department;
import com.springProjects.libararyManagementSystem.model.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResDto {
    private String name;
    private int age;
    private Department department;
    private String mobNo;
    private CardResDto card;
}
