package com.springProjects.libararyManagementSystem.service.impl;

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
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "Author added";
    }

}
