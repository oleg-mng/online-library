package com.olemng.onlinelibrary.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
// @Entity
public class Issue {

    public static long sequence = 1L;

    private final long id;
    private final long bookId;
    private final long readerId;

    /**
     * Дата выдачи
     */
    private final LocalDateTime timestamp;

    public Issue(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now();
    }

}