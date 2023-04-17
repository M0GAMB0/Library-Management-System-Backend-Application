package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;
import com.springProjects.libararyManagementSystem.model.Author;
import com.springProjects.libararyManagementSystem.model.Book;
import com.springProjects.libararyManagementSystem.repository.AuthorRepository;
import com.springProjects.libararyManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookReqDto bookReqDto) throws Exception {
        Author author;
        try{
            author=authorRepository.findById(bookReqDto.getIdReqDto().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present in Database.");
        }
        //Converting DTO to Entity
        Book book=new Book();
        book.setAuthor(author);
        book.setGenre(bookReqDto.getGenre());
        book.setTitle(bookReqDto.getTitle());
        book.setPrice(bookReqDto.getPrice());
        book.setNoOfPages(bookReqDto.getNoOfPages());

        //Updating author's data
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);


        return "Book added";
    }
}
