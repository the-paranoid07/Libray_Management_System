package com.example.Librarymanagementsystem.controller;

import com.example.Librarymanagementsystem.entity.Student;
import com.example.Librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam int id){
        return studentService.deleteStudent(id);
    }

}
