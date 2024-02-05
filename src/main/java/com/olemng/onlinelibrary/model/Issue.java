package com.olemng.onlinelibrary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "issues")
@Data
public class Issue {

    @Id
    private long id;
    @Column(name="bookId")
    private long bookId;
    @Column(name="readerId")
    private long readerId;

    /**
     * Дата выдачи
     */
    private LocalDateTime timestamp;
    private LocalDateTime dueDate;

    public Issue(long id, long bookId, long readerId, LocalDateTime dueDate) {
        this.dueDate = dueDate;
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.timestamp = LocalDateTime.now().minusDays(3);;
    }

    public Issue() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}