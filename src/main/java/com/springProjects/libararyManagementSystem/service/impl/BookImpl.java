package com.springProjects.libararyManagementSystem.service.impl;

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
    public String addBook(Book book) throws Exception {
        Author author;
        try{
            author=authorRepository.findById(book.getAuthor().getAuthorId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present in Database.");
        }
        author.getBooks().add(book);
        book.setAuthor(author);
        authorRepository.save(author);
        return "Book added";
    }
}
