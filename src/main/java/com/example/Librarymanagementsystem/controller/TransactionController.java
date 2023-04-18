package com.example.Librarymanagementsystem.controller;

import com.example.Librarymanagementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.ReturnBookResponseDto;
import com.example.Librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto)throws Exception{
        return transactionService.issueBook(issueBookRequestDto);
    }

    @PostMapping("/return-book")
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception {
        return transactionService.returnBook(returnBookRequestDto);
    }


}
