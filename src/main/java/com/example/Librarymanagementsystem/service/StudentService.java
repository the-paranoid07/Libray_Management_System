package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Librarymanagementsystem.entity.Student;
import com.example.Librarymanagementsystem.exceptions.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);
    public StudentResponseDto getStudentById(int id)throws StudentNotFoundException;

    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException;

    public String deleteStudent(int id)throws StudentNotFoundException;

    public List<StudentResponseDto> getAllStudents();
}
