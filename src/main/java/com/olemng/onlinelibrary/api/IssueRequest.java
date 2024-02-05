package com.olemng.onlinelibrary.api;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Запрос на выдачу
 */
@Data
public class IssueRequest {

    private long id;

    public LocalDateTime getDueDate;
    /**
     * Идентификатор читателя
     */
    private long readerId;

    /**
     * Идентификатор книги
     */
    private long bookId;

}