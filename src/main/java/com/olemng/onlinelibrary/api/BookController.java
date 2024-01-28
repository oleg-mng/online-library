package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("{id}")
    public String getBook(@PathVariable long id){
        return bookRepository.getBookDescById(id);
    }

    @DeleteMapping("{id}")
    public List<Book> deleteBook(@PathVariable long id){
        return bookRepository.deleteBookById(id);
    }

    @PostMapping
    public List<Book> addBook(@RequestBody Book book){
        return bookRepository.addBook(book);
    }

}
