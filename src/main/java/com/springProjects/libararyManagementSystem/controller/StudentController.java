package com.springProjects.libararyManagementSystem.controller;

import com.springProjects.libararyManagementSystem.model.Student;
import com.springProjects.libararyManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @DeleteMapping("/deleteStudent")
    public String deleteStudentById(@RequestParam int studentId){
        return studentService.deleteStudentById(studentId);
    }
}
