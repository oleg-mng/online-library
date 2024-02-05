package com.olemng.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "books")
@Data
public class Book {

//    public static long sequence = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public Book() {

    }

    public Book(long id, String name) {
        this.id = id;
        this.name = name;
    }
}