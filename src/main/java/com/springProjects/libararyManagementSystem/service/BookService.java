package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    public String addBook(BookReqDto bookReqDto) throws Exception;

}
