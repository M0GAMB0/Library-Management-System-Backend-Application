package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.model.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public String addBook(Book book) throws Exception;

}
