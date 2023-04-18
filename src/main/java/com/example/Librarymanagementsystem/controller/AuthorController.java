package com.example.Librarymanagementsystem.controller;

import com.example.Librarymanagementsystem.DTO.RequestDto.AuthorRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagementsystem.entity.Author;
import com.example.Librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }

    @GetMapping("/get-author-by-name")
    public AuthorResponseDto getAuthorByName(@RequestParam String name)throws Exception{
        return authorService.getAuthorByName(name);
    }

    @GetMapping("/get-all-authors")
    public List<AuthorResponseDto> getAllAuthors()throws  Exception{
        return authorService.getAllAuthors();
    }

}
