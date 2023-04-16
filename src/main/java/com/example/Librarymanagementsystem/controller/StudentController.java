package com.example.Librarymanagementsystem.controller;

import com.example.Librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Librarymanagementsystem.entity.Student;
import com.example.Librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.Librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }

    @GetMapping("/find-student")
    public StudentResponseDto getStudentById(@RequestParam int id )throws StudentNotFoundException{
        return studentService.getStudentById(id);
    }

    @PutMapping("/update-mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobNoRequestDto);
    }

    @DeleteMapping("/delete-student")
    public String deleteStudent(@RequestParam int id)throws StudentNotFoundException{
        return studentService.deleteStudent(id);
    }
    @GetMapping("/get-all-students")
    public List<StudentResponseDto> getAllStudents(){
        return studentService.getAllStudents();
    }

}
