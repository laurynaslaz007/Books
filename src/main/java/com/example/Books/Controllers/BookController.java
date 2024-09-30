package com.example.Books.Controllers;

import com.example.Books.Models.Book;
import com.example.Books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public Iterable<Book> getAllBook(){
        return bookService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Optional <Book> book=bookService.findById(id);
        if(book.isPresent()){
            return ResponseEntity.ok(book.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookService.save(book);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
        Optional<Book>book=bookService.findById(id);
        if(book.isPresent()){
            Book updatedBook= book.get();
            updatedBook.setTitle(bookDetails.getTitle());
            updatedBook.setYear(bookDetails.getYear());
            updatedBook.setAuthor(bookDetails.getAuthor());
            updatedBook.setRating(bookDetails.getRating());
            return ResponseEntity.ok(bookService.save(updatedBook));
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
