package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.StudentReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.UpdateStudentMobNoReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.StudentResDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.UpdateStudentMobNoResDto;
import com.springProjects.libararyManagementSystem.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public String addStudent(StudentReqDto student);
    public String deleteStudentById(IDReqDto idReqDto) throws StudentNotFoundException;
    public UpdateStudentMobNoResDto updateMobNo(UpdateStudentMobNoReqDto updateStudentMobNoDto) throws StudentNotFoundException;
    public StudentResDto getStudentById(IDReqDto idReqDto) throws StudentNotFoundException;

    public List<StudentResDto> getAllStudents();
}
