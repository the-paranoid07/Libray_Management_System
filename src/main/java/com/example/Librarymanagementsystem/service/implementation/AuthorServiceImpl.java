package com.example.Librarymanagementsystem.service.implementation;

import com.example.Librarymanagementsystem.DTO.RequestDto.AuthorRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.BookResponseDto;
import com.example.Librarymanagementsystem.entity.Author;
import com.example.Librarymanagementsystem.entity.Book;
import com.example.Librarymanagementsystem.repository.AuthorRepository;
import com.example.Librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(AuthorRequestDto authorRequestDto) {

        Author author=new Author();
        author.setName(authorRequestDto.getName());
        author.setEmail(authorRequestDto.getEmail());
        author.setAge(authorRequestDto.getAge());

        authorRepository.save(author);

        return "Author added successfully";
    }

    @Override
    public AuthorResponseDto getAuthorByName(String name) throws Exception{

        Author author;

        try{
            author=authorRepository.findByName(name);
        }catch (Exception e){
            throw new Exception("Author does not exist");
        }

        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setAge(author.getAge());
        authorResponseDto.setName(author.getName());
        authorResponseDto.setEmail(author.getEmail());

        List<String>books=new ArrayList<>();

        for(Book book:author.getBookList()){
            books.add(book.getTitle());
        }
        authorResponseDto.setBookList(books);



        return authorResponseDto;
    }

    @Override
    public List<AuthorResponseDto> getAllAuthors() throws Exception {
       List<Author>authors=authorRepository.findAll();
       List<AuthorResponseDto>authorResponseDtoList=new ArrayList<>();

       for(Author author:authors){
           AuthorResponseDto authorResponseDto=getAuthorByName(author.getName());
           authorResponseDtoList.add(authorResponseDto);
       }
       return authorResponseDtoList;
    }
}
