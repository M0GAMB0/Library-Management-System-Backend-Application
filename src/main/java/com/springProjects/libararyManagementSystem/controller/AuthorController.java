package com.springProjects.libararyManagementSystem.controller;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.AuthorReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.AuthorResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import com.springProjects.libararyManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")//passed by POSTMAN
    public String addAuthor(@RequestBody AuthorReqDto authorReqDto){
        return authorService.addAuthor(authorReqDto);
    }

    @DeleteMapping("/delete-author-By-Id")//passed by POSTMAN
    public String deleteAuthorByID(@RequestBody IDReqDto idReqDto) throws AuthorNotFoundException {
        return authorService.deleteById(idReqDto);
    }
    @GetMapping("/get-all-authors")
    public List<AuthorResDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }
    //get all the authors of particular age
    @GetMapping("/get-all-the-authors-of-particular-age/{age}")
    public List<AuthorResDto> getAllTheAuthorsOfParticularAge(@PathVariable("age") int age){
        return  authorService.getAllTheAuthorsOfParticularAge(age);
    }
}
