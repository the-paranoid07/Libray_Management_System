package com.example.Librarymanagementsystem.service.implementation;

import com.example.Librarymanagementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.UpdateStudentMobNoRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.CardResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Librarymanagementsystem.entity.Card;
import com.example.Librarymanagementsystem.entity.Student;
import com.example.Librarymanagementsystem.enums.CardStatus;
import com.example.Librarymanagementsystem.exceptions.StudentNotFoundException;
import com.example.Librarymanagementsystem.repository.StudentRepository;
import com.example.Librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setValidTill("2025-01-01");

        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setDepartment(studentRequestDto.getDepartment());


        card.setStudent(student);
        student.setCard(card);

        studentRepository.save(student);

        return "Student added successfully";

    }

    @Override
    public StudentResponseDto getStudentById(int id) throws StudentNotFoundException{
        Student student;

        try {
            student=studentRepository.findById(id).get();

        }catch (Exception e){
            throw new StudentNotFoundException("Student Id does not exist");
        }
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setDepartment(student.getDepartment());
        studentResponseDto.setMobNo(student.getMobNo());

        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setValidTill(student.getCard().getValidTill());
        cardResponseDto.setCardStatus(student.getCard().getCardStatus());
        cardResponseDto.setId(student.getCard().getId());
        cardResponseDto.setIssueDate(student.getCard().getIssueDate());

        studentResponseDto.setCardResponseDto(cardResponseDto);

        return studentResponseDto;
    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobNoRequestDto updateStudentMobNoRequestDto) throws StudentNotFoundException {
        Student student;
        try{
            student=studentRepository.findById(updateStudentMobNoRequestDto.getId()).get();
            student.setMobNo(updateStudentMobNoRequestDto.getMobNo());
        }catch (Exception e){
            throw new StudentNotFoundException("Student Id does not exist");
        }
        UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto=new UpdateStudentMobNoResponseDto();
        updateStudentMobNoResponseDto.setName(student.getName());
        updateStudentMobNoResponseDto.setMobNo(student.getMobNo());

        studentRepository.save(student);

        return updateStudentMobNoResponseDto;
    }

    @Override
    public String deleteStudent(int id) throws StudentNotFoundException{

        Student student;
        try{
            student=studentRepository.findById(id).get();
            studentRepository.delete(student);
        }catch (Exception e){
            throw new StudentNotFoundException("Student id does not exist");
        }

        return "Student record removed successfully";

    }

    @Override
    public List<StudentResponseDto> getAllStudents() {
        List<Student>studentList=studentRepository.findAll();
        List<StudentResponseDto>studentResponseDtotList=new ArrayList<>();

        for(Student student:studentList){
            StudentResponseDto studentResponseDto=new StudentResponseDto();
            studentResponseDto.setId(student.getId());
            studentResponseDto.setName(student.getName());
            studentResponseDto.setMobNo(student.getMobNo());
            studentResponseDto.setDepartment(student.getDepartment());

            CardResponseDto cardResponseDto=new CardResponseDto();
            cardResponseDto.setId(student.getCard().getId());
            cardResponseDto.setCardStatus(student.getCard().getCardStatus());
            cardResponseDto.setValidTill(student.getCard().getValidTill());

            studentResponseDto.setCardResponseDto(cardResponseDto);

            studentResponseDtotList.add(studentResponseDto);
        }
        return studentResponseDtotList;
    }
}
