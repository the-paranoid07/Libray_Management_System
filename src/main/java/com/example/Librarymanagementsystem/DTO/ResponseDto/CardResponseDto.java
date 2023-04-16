package com.example.Librarymanagementsystem.DTO.ResponseDto;

import com.example.Librarymanagementsystem.enums.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponseDto {
    private int id;
    private CardStatus cardStatus;
    private Date issueDate;
    private String validTill;
}
