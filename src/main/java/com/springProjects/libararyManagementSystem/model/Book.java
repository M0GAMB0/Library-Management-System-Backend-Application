package com.springProjects.libararyManagementSystem.model;

import com.springProjects.libararyManagementSystem.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int bookId;

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private int noOfPages;

    private int price;

    @ManyToOne
    @JoinColumn
    Author author;
}
