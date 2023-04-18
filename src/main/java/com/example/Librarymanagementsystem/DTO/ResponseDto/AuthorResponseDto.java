package com.example.Librarymanagementsystem.DTO.ResponseDto;

import com.example.Librarymanagementsystem.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorResponseDto {
    private int id;
    private String name;
    private int age;
    private String email;
    List<String> bookList;
}
