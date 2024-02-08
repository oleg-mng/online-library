package com.olemng.onlinelibrary.service;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        bookRepository.save(new Book(1, "Источник"));
        bookRepository.save(new Book(2, "Spring5 для профессионалов"));
        bookRepository.save(new Book(3, "чистый код"));

        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    public List<Book> getBookByName(String name) {
        return bookRepository.findBookByName(name);
    }

    public List<Book> deleteBookById(Long id) {
        bookRepository.deleteBookById(id);
        return bookRepository.findAll();
    }

    public List<Book> saveBook(Long id, String name) {
        bookRepository.save(new Book(1, name));

        return bookRepository.findAll();
    }

//    List<Book> updateBook(Book book);
//    List<Book> findBooks();
}
