package com.springProjects.libararyManagementSystem.DTOs.ResDto;

import com.springProjects.libararyManagementSystem.enums.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResDto {
    private LocalDate issueDate;
    private Date lastUpdated;
    private CardStatus status;
    private LocalDate validTill;
}
