package com.example.Librarymanagementsystem.service;

import com.example.Librarymanagementsystem.DTO.RequestDto.AuthorRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagementsystem.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public interface AuthorService {

    public String addAuthor(AuthorRequestDto authorRequestDto);
    public AuthorResponseDto getAuthorByName(String name)throws Exception;

    List<AuthorResponseDto> getAllAuthors() throws Exception;
}
