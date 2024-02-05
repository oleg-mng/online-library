package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllReaders() {

        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }

//    @GetMapping
//    public String getList(Model model) {
//        model.addAttribute("books", bookService.getAllBooks());
//        return "books";
//    }


//    @GetMapping("{id}")
//    public Book getBook(@PathVariable long id){
//        return bookRepository.findBookById(id);
//    }

    @DeleteMapping("{id}")
    public List<Book> deleteBook(@PathVariable long id) {
        return bookService.deleteBookById(id);
    }

    @PostMapping("/add")
    public List<Book> addBook(@RequestBody Long id, String name) {
        return bookService.saveBook(id, name);
    }

}
