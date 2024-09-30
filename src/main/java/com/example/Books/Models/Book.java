package com.example.Books.Models;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="title")
    private String title;

    @Column(name="year")
    private long year;

    @Column(name="author")
    private String author;

    @Column(name="rating")
    private long rating;
}
