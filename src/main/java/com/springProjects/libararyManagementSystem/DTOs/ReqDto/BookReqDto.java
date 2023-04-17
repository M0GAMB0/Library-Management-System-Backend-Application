package com.springProjects.libararyManagementSystem.DTOs.ReqDto;

import com.springProjects.libararyManagementSystem.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookReqDto {
    private String title;
    private Genre genre;
    private int noOfPages;
    private int price;
    private IDReqDto idReqDto;
}
