package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.entity.Student;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public String addStudent(Student student);

   public String deleteStudent(int id);
}
