package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.DTO.RequestDto.BookRequestDto;
import com.example.Librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public String addBook(BookRequestDto bookRequestDto) throws Exception;
}
