package com.example.Librarymanagementsystem.DTO.RequestDto;

import com.example.Librarymanagementsystem.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequestDto {
    private String title;
    private int numberOfPages;
    private double price;

    private Genre genre;
    private int authorId;



}
