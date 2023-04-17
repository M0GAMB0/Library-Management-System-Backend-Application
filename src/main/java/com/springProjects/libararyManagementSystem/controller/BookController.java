package com.springProjects.libararyManagementSystem.controller;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.BookResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import com.springProjects.libararyManagementSystem.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    BookService bookService;
    @PostMapping("/add-book")
    public String addBook(@RequestBody BookReqDto bookReqDto) throws Exception{
        return bookService.addBook(bookReqDto);
    }

    //find all the books
    @GetMapping("/getAllBooks")
    public List<BookResDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    //find all the books of particular authorID
    @GetMapping("/get-books-of-author")
    public List<BookResDto> getBookByAuthorID(@RequestBody IDReqDto idReqDto) throws AuthorNotFoundException {
        return bookService.getBooksByAuthorId(idReqDto);
    }
    //find no of book written by an author
    @GetMapping("/number-Of-Books-Written-By-Author")
    public int getNumberOfBooksWrittenByAuthor(@RequestBody IDReqDto idReqDto) throws AuthorNotFoundException {
        return bookService.getNumberOfBooksWrittenByAuthor(idReqDto);
    }
}
