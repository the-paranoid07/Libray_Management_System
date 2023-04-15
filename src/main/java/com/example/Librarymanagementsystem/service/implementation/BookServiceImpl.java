package com.example.Librarymanagementsystem.service.implementation;

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
    public String addBook(Book book) throws Exception {

        Author author;

        try {
            author=authorRepository.findById(book.getAuthor().getId()).get();
        }catch (Exception e){
            throw new Exception("Author does not exist");
        }

        book.setAuthor(author);
        author.getBookList().add(book);

        authorRepository.save(author);


        return "Book added successfully";

    }
}
