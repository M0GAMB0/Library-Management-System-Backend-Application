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

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")//passed by PostMan
    public String addStudent(@RequestBody StudentReqDto studentReqDto){
        return studentService.addStudent(studentReqDto);
    }

    //update student's mobile number
    @PutMapping("/update-mobile")//passed by PostMan
    public UpdateStudentMobNoResDto updateMobNo(@RequestBody UpdateStudentMobNoReqDto updateStudentMobNoDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobNoDto);
    }
    //delete a student by id
    @DeleteMapping("/deleteStudent")//passed by PostMan
    public String deleteStudentById(@RequestBody IDReqDto idReqDto) throws StudentNotFoundException {
        return studentService.deleteStudentById(idReqDto);
    }

    //find a student by id
    @GetMapping("/get-student")//passed by PostMan
    public StudentResDto getStudentById(@RequestBody IDReqDto idReqDto) throws StudentNotFoundException {
        return studentService.getStudentById(idReqDto);
    }

    //find all the students
    @GetMapping("/get-All-Students")//passed by PostMan
    public List<StudentResDto>  getAllStudents(){
        return studentService.getAllStudents();
    }

}
