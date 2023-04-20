package com.springProjects.libararyManagementSystem.service.impl;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.AuthorReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.AuthorResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import com.springProjects.libararyManagementSystem.model.Author;
import com.springProjects.libararyManagementSystem.repository.AuthorRepository;
import com.springProjects.libararyManagementSystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String deleteById(IDReqDto idReqDto) throws AuthorNotFoundException {
        try{
            Author author=authorRepository.findById(idReqDto.getId()).get();
            authorRepository.deleteById(idReqDto.getId());
            return "Author Deleted";
        }
       catch(Exception e){
            throw new AuthorNotFoundException("Invalid Author ID");
        }
    }

    @Override
    public List<AuthorResDto> getAllAuthors() {
        List<AuthorResDto> authorsList=new ArrayList<>();
        List<Author> authors=authorRepository.findAll();
        for(Author author:authors){
            AuthorResDto authorResDto=new AuthorResDto();
            authorResDto.setName(author.getName());
            authorResDto.setAge(author.getAge());
            authorResDto.setEmail(author.getEmail());
        }
        return authorsList;
    }

    @Override
    public List<AuthorResDto> getAllTheAuthorsOfParticularAge(int age) {
        List<AuthorResDto> authorsList=new ArrayList<>();
        List<AuthorResDto> authors=this.getAllAuthors();
        for(AuthorResDto author:authors){
            if(author.getAge()==age){
                authorsList.add(author);
            }
        }
        return authorsList;
    }
}


