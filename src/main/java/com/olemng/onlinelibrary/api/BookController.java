package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
@Tag(name = "Book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Getting all available books in the system")
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get the book by the id", description = "Getting unique book in the system")
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
    @Operation(summary = "Getting unique book by id", description = "Deleting unique book in the system")
    public List<Book> deleteBook(@PathVariable long id) {
        return bookService.deleteBookById(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Adding new book", description = "Saving new book in Repository")
    public List<Book> addBook(@RequestBody Long id, String name) {
        return bookService.saveBook(id, name);
    }

}
