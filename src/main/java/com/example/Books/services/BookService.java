package com.example.Books.services;

import com.example.Books.Models.Book;
import com.example.Books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Iterable<Book> findAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }
    public Book save(Book book){
        return bookRepository.save(book);
    }
    public void deleteById(Long id){
        bookRepository.deleteById((id));
    }
}

