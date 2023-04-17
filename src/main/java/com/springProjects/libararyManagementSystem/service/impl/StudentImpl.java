package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.StudentReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.UpdateStudentMobNoReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.CardResDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.StudentResDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.UpdateStudentMobNoResDto;
import com.springProjects.libararyManagementSystem.enums.CardStatus;
import com.springProjects.libararyManagementSystem.exception.StudentNotFoundException;
import com.springProjects.libararyManagementSystem.model.Card;
import com.springProjects.libararyManagementSystem.model.Student;
import com.springProjects.libararyManagementSystem.repository.StudentRepository;
import com.springProjects.libararyManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class StudentImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentReqDto studentReqDto) {
        //Service Layer converting DTOs to Entity.
        Student student=new Student();
        student.setAge(studentReqDto.getAge());
        student.setName(studentReqDto.getName());
        student.setDepartment(studentReqDto.getDepartment());
        student.setMobNo(studentReqDto.getMobNo());

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
    public String deleteStudentById(IDReqDto idReqDto) throws StudentNotFoundException {
        try{
            Student student=studentRepository.findById(idReqDto.getId()).get();
            studentRepository.deleteById(idReqDto.getId());
            return student.getName()+"'s account has been deleted.";
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid Student ID");
        }
    }

    @Override
    public UpdateStudentMobNoResDto updateMobNo(UpdateStudentMobNoReqDto updateStudentMobNoDto) throws StudentNotFoundException {
        try{
            //Finding that student by his ID in repository
            Student student=studentRepository.findById(updateStudentMobNoDto.getId()).get();
            //updating student's mobile NO
            student.setMobNo(updateStudentMobNoDto.getMobNo());
            studentRepository.save(student);

            //Prepare response DTO
            UpdateStudentMobNoResDto updateStudentMobNoResDto=new UpdateStudentMobNoResDto();
            updateStudentMobNoResDto.setMobNo(student.getMobNo());
            updateStudentMobNoResDto.setName(student.getName());

            return updateStudentMobNoResDto;
        }
        catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public StudentResDto updateStudentByID(IDReqDto idReqDto) throws StudentNotFoundException {
        try{
            Student student=studentRepository.findById(idReqDto.getId()).get();
            StudentResDto studentResDto=new StudentResDto();
            studentResDto.setName(student.getName());
            studentResDto.setDepartment(student.getDepartment());
            studentResDto.setAge(studentResDto.getAge());
            studentResDto.setMobNo(student.getMobNo());

            //preparing card DTO
            CardResDto cardResDto=new CardResDto();
            cardResDto.setIssueDate(studentResDto.getCard().getIssueDate());
            cardResDto.setLastUpdated(studentResDto.getCard().getLastUpdated());
            cardResDto.setStatus(studentResDto.getCard().getStatus());
            cardResDto.setValidTill(student.getCard().getValidTill());

            studentResDto.setCard(cardResDto);

            return studentResDto;
        }
        catch(Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }
}
