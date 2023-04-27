package com.springProjects.libararyManagementSystem.controller;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.BookResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import com.springProjects.libararyManagementSystem.service.BookService;
import com.springProjects.libararyManagementSystem.service.impl.BookImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://lucky-year-production.up.railway.app/")
@RequestMapping("/book")
@RestController
public class BookController{
    BookService bookService=new BookImpl();
    @PostMapping("/add-books")
    public String addBook(BookReqDto bookReqDto) throws AuthorNotFoundException {
        return bookService.addBook(bookReqDto);
    }
    @GetMapping("/get-all-books")
    public List<BookResDto> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping("/get-books-by-author-id")
    public List<BookResDto> getBooksByAuthorId(IDReqDto idReqDto) throws AuthorNotFoundException {
        return bookService.getBooksByAuthorId(idReqDto);
    }
    @GetMapping("/get-number-of-books-written-by-author")
    public int getNumberOfBooksWrittenByAuthor(IDReqDto idReqDto) throws AuthorNotFoundException {
        return bookService.getNumberOfBooksWrittenByAuthor(idReqDto);
    }
}