package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.entity.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {

    public String addAuthor(Author author);
}
