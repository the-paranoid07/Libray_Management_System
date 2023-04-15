package com.example.Librarymanagementsystem.service.implementation;

import com.example.Librarymanagementsystem.entity.Card;
import com.example.Librarymanagementsystem.entity.Student;
import com.example.Librarymanagementsystem.enums.CardStatus;
import com.example.Librarymanagementsystem.repository.StudentRepository;
import com.example.Librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(Student student) {

        //generating card for the student
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        //issueing card to the student
        student.setCard(card);
        studentRepository.save(student);

        return "Student added successfully";
    }

    @Override
    public String deleteStudent(int id) {

        return "Student record removed successfully";

    }
}
