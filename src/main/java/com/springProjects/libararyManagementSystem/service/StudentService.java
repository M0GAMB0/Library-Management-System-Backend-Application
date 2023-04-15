package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.model.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    public String addStudent(Student student);
    public String deleteStudentById(int studentId);
}
