package com.springProjects.libararyManagementSystem.model;

import com.springProjects.libararyManagementSystem.enums.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Card")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    @CreationTimestamp
    private LocalDate issueDate;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    private LocalDate validTill;

    @OneToOne
    @JoinColumn
    Student student;
}
