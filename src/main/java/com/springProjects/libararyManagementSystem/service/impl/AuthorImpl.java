package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.AuthorReqDto;
import com.springProjects.libararyManagementSystem.model.Author;
import com.springProjects.libararyManagementSystem.repository.AuthorRepository;
import com.springProjects.libararyManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addAuthor(AuthorReqDto authorReqDto) {
        //Converting DTO to Entity
        Author author = new Author();
        author.setAge(authorReqDto.getAge());
        author.setName(authorReqDto.getName());
        author.setEmail(authorReqDto.getEmail());

        authorRepository.save(author);
        return "Author added";
    }

}
