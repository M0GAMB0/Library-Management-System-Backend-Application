package com.springProjects.libararyManagementSystem.service;

import com.springProjects.libararyManagementSystem.DTOs.ReqDto.AuthorReqDto;
import com.springProjects.libararyManagementSystem.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    public String addAuthor(AuthorReqDto authorReqDto);
}
