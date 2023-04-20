package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.AuthorReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ReqDto.IDReqDto;
import com.springProjects.libararyManagementSystem.DTOs.ResDto.AuthorResDto;
import com.springProjects.libararyManagementSystem.exception.AuthorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public String addAuthor(AuthorReqDto authorReqDto);

    public String deleteById(IDReqDto idReqDto) throws AuthorNotFoundException;

    public List<AuthorResDto> getAllTheAuthorsOfParticularAge(int age);

    public List<AuthorResDto> getAllAuthors();
}