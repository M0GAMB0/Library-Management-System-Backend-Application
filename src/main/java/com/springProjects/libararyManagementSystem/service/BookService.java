package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.BookResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public String addBook(BookReqDto bookReqDto) throws AuthorNotFoundException;
    public List<BookResDto> getAllBooks();
    public List<BookResDto> getBooksByAuthorId(IDReqDto idReqDto) throws AuthorNotFoundException;
    public int getNumberOfBooksWrittenByAuthor(IDReqDto idReqDto) throws AuthorNotFoundException;

}
