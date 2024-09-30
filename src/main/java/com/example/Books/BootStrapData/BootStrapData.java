package com.example.Books.BootStrapData;

import com.example.Books.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    public BootStrapData(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public void run(String... args){
        System.out.println("Book application start");
    }
}
