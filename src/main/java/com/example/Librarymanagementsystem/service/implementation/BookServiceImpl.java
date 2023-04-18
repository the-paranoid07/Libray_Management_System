package com.example.Librarymanagementsystem.service.implementation;

import com.example.Librarymanagementsystem.DTO.RequestDto.BookRequestDto;
import com.example.Librarymanagementsystem.entity.Author;
import com.example.Librarymanagementsystem.entity.Book;
import com.example.Librarymanagementsystem.repository.AuthorRepository;
import com.example.Librarymanagementsystem.repository.BookRepository;
import com.example.Librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Override
    public String addBook(BookRequestDto bookRequestDto) throws Exception {

        Author author;

        try {
            author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        }catch (Exception e){
            throw new Exception("Author does not exist");
        }

        Book book=new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setNumberOfPages(bookRequestDto.getNumberOfPages());
        book.setPrice(bookRequestDto.getPrice());
        book.setGenre(bookRequestDto.getGenre());
        book.setAuthor(author);

        author.getBookList().add(book);

        authorRepository.save(author);


        return "Book added successfully";

    }
}
