package com.example.Librarymanagementsystem.service.implementation;

import com.example.Librarymanagementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Librarymanagementsystem.DTO.RequestDto.ReturnBookRequestDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Librarymanagementsystem.DTO.ResponseDto.ReturnBookResponseDto;
import com.example.Librarymanagementsystem.entity.Book;
import com.example.Librarymanagementsystem.entity.Card;
import com.example.Librarymanagementsystem.entity.Transaction;
import com.example.Librarymanagementsystem.enums.CardStatus;
import com.example.Librarymanagementsystem.enums.TransactionStatus;
import com.example.Librarymanagementsystem.repository.BookRepository;
import com.example.Librarymanagementsystem.repository.CardRepository;
import com.example.Librarymanagementsystem.repository.TransactionRepository;
import com.example.Librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{

        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setIssueType(true);

        Card card;
        try{
            card=cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card Id not Valid");
        }
        transaction.setCard(card);

        Book book;
        try{
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book Id not Valid");
        }

        transaction.setBook(book);

        if(card.getCardStatus() != CardStatus.ACTIVE){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card not active");
        }

        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book not available right now. Already issued!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //setting book attributes
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        //setting card atributess
        card.getBooksIssuedList().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);//card-->parent of book and transaction-->will save both automatically

        //prepare response DTO

        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto(transaction.getTransactionNumber(),
                transaction.getTransactionStatus(),book.getTitle());

        return issueBookResponseDto;

    }

    @Override
    public ReturnBookResponseDto returnBook(ReturnBookRequestDto returnBookRequestDto) throws Exception {
        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(UUID.randomUUID().toString());
        transaction.setIssueType(false);

        Book book;
        Card card;
        try{
            book=bookRepository.findById(returnBookRequestDto.getBookId()).get();
            if(book.isIssued()){
                try{
                    card=cardRepository.findById(returnBookRequestDto.getCardId()).get();
                    if(book.getCard().getId() != card.getId()){
                        transaction.setTransactionStatus(TransactionStatus.FAILED);
                        transactionRepository.save(transaction);
                        throw new Exception("Book not issued to given card id. Enter correct card id.");
                    }
                }catch (Exception e){
                    transaction.setTransactionStatus(TransactionStatus.FAILED);
                    transactionRepository.save(transaction);
                    throw new Exception("Card Id not Valid");
                }
            }else {
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transactionRepository.save(transaction);
                throw new Exception("Book not issued");
            }
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book Id not Valid");
        }



        transaction.setCard(card);
        transaction.setBook(book);


        transaction.setTransactionStatus(TransactionStatus.SUCCESS);

        //setting book attributes
        book.setIssued(false);
        book.setCard(null);
        book.getTransactionList().add(transaction);

        //setting card atributess
        card.getBooksIssuedList().remove(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);//card-->parent of book and transaction-->will save both automatically

        //prepare response DTO

        ReturnBookResponseDto returnBookResponseDto=new ReturnBookResponseDto(
                transaction.getTransactionNumber(),transaction.getTransactionStatus(),book.getTitle());

        return returnBookResponseDto;

    }
}
