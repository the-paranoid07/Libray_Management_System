package com.example.Librarymanagementsystem.controller;

import com.example.Librarymanagementsystem.DTO.RequestDto.BookRequestDto;
import com.example.Librarymanagementsystem.entity.Book;
import com.example.Librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception{
        return bookService.addBook(bookRequestDto);
    }
}
