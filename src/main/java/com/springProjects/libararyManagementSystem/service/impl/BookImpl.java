package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.BookReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.AuthorResDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.BookResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import com.springProjects.libararyManagementSystem.model.Author;
import com.springProjects.libararyManagementSystem.model.Book;
import com.springProjects.libararyManagementSystem.repository.AuthorRepository;
import com.springProjects.libararyManagementSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(BookReqDto bookReqDto) throws AuthorNotFoundException {
        try{
            if(bookReqDto==null){
                return "NuLL";
            }
            bookReqDto.println();
            System.out.println("reached impl");
            Book book=new Book();
            Author author=authorRepository.findById(bookReqDto.getAuthor().getId()).get();
            book.setAuthor(author);
            book.setTitle(bookReqDto.getTitle());
            book.setGenre(bookReqDto.getGenre());
            book.setPrice(bookReqDto.getPrice());
            book.setNoOfPages(bookReqDto.getNoOfPages());
            authorRepository.save(author);

        }
        catch (Exception e){
            throw new AuthorNotFoundException("Invalid Author ID");
        }
        return "Book added";
    }

    @Override
    public List<BookResDto> getAllBooks() {
        List<BookResDto> resBooks=new ArrayList<>();
        List<Author> authors=authorRepository.findAll();
        for(Author author:authors){
            for(Book book:author.getBooks()){
                BookResDto bookResDto=new BookResDto();
                bookResDto.setTitle(book.getTitle());
                bookResDto.setGenre(book.getGenre());
                bookResDto.setPrice(book.getPrice());
                bookResDto.setNoOfPages(book.getNoOfPages());

                //setting author DTO
                AuthorResDto authorResDto=new AuthorResDto();
                authorResDto.setName(book.getAuthor().getName());
                authorResDto.setEmail(book.getAuthor().getEmail());
                authorResDto.setAge(book.getAuthor().getAge());

                //inserting author DTO
                bookResDto.setAuthorResDto(authorResDto);
                resBooks.add(bookResDto);
            }
        }
        return resBooks;
    }

    @Override
    public List<BookResDto> getBooksByAuthorId(IDReqDto idReqDto) throws AuthorNotFoundException {
        try{
            Author author=authorRepository.findById(idReqDto.getId()).get();
            List<BookResDto> bookResDtoList=new ArrayList<>();
            for(Book book:author.getBooks()){
                BookResDto bookResDto=new BookResDto();
                bookResDto.setTitle(book.getTitle());
                bookResDto.setGenre(book.getGenre());
                bookResDto.setPrice(book.getPrice());
                bookResDto.setNoOfPages(book.getNoOfPages());

                AuthorResDto authorResDto=new AuthorResDto();
                authorResDto.setName(book.getAuthor().getName());
                authorResDto.setEmail(book.getAuthor().getEmail());
                authorResDto.setAge(book.getAuthor().getAge());

                bookResDto.setAuthorResDto(authorResDto);
                bookResDtoList.add(bookResDto);
            }
            return bookResDtoList;
        }
        catch (Exception e){
            throw new AuthorNotFoundException("Invalid Author Id");
        }
    }
    public int getNumberOfBooksWrittenByAuthor(IDReqDto idReqDto) throws AuthorNotFoundException {
       try{
           Author author=authorRepository.findById(idReqDto.getId()).get();
           return author.getBooks().size();
       }
       catch(Exception e){
           throw new AuthorNotFoundException("Invalid Author Id");
       }
    }
}
