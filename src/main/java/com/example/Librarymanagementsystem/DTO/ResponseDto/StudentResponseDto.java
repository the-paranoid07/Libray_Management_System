package com.example.Librarymanagementsystem.DTO.ResponseDto;

import com.example.Librarymanagementsystem.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    private int id;
    private String name;
    private String mobNo;
    private Department department;
    private CardResponseDto cardResponseDto;
}
