package com.olemng.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;

    public Reader() {

    }

    public Reader(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
