package com.springProjects.libararyManagementSystem.controller;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.StudentReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.UpdateStudentMobNoReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.StudentResDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.UpdateStudentMobNoResDto;
import com.springProjects.libararyManagementSystem.exception.StudentNotFoundException;
import com.springProjects.libararyManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.addStudent(studentReqDto);
    }
    @PutMapping("/update-mobile")
    public UpdateStudentMobNoResDto updateMobNo(@RequestBody UpdateStudentMobNoReqDto updateStudentMobNoDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobNoDto);
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudentById(@RequestBody IDReqDto idReqDto) throws StudentNotFoundException {
        return studentService.deleteStudentById(idReqDto);
    }

    @GetMapping("/get-student")
    public StudentResDto updateStudentByID(@RequestBody IDReqDto idReqDto) throws StudentNotFoundException {
        return studentService.updateStudentByID(idReqDto);
    }
}
