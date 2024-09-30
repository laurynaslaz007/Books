package com.example.Books.repository;

import com.example.Books.Models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByYear(Long year);

    List<Book> findByRating(Long rating);

    @Query("SELECT b FROM Book b WHERE " +
            "(:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:year IS NULL OR b.year = :year) AND " +
            "(:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))) AND " +
            "(:rating IS NULL OR b.rating = :rating)")
    List<Book> findBooksByFilters(
            @Param("title") String title,
            @Param("year") Long year,
            @Param("author") String author,
            @Param("rating") Long rating
    );
}
