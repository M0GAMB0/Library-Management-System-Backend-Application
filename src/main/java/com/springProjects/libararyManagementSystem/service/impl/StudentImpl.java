package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.enums.CardStatus;
import com.springProjects.libararyManagementSystem.model.Card;
import com.springProjects.libararyManagementSystem.model.Student;
import com.springProjects.libararyManagementSystem.repository.StudentRepository;
import com.springProjects.libararyManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class StudentImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(Student student) {
        //Generate new card for student
        Card card=new Card();
        card.setStatus(CardStatus.ACTIVE);
//        card.setValidTill(new Date(card.getIssueDate().getYear(),card.getIssueDate().getMonth(),card.getIssueDate().getDate()));
        card.setValidTill(LocalDate.now().plusYears(2L));
        card.setStudent(student);

        //setting new card for student
        student.setCard(card);

        //saving in repo
        studentRepository.save(student);


        return "Student Registered";
    }

    @Override
    public String deleteStudentById(int studentId) {
        studentRepository.deleteById(studentId);
        return "Student deleted";
    }
}
