package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.ReturnBookResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService{

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;

    ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception;
}
