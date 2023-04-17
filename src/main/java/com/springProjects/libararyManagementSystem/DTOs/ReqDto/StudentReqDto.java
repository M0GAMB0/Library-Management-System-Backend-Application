package com.springProjects.libararyManagementSystem.DTOs.ReqDto;

import com.springProjects.libararyManagementSystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentReqDto {
    private String name;
    private int age;
    private Department department;
    private String mobNo;
}
