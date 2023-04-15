package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    public String addBook(Book book) throws Exception;
}
