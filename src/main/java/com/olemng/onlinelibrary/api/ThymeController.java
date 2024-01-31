package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.repository.IssueRepository;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ui")
public class ThymeController {

@Autowired
    private BookRepository books;

@Autowired
private ReaderRepository readers;

@Autowired
private IssueRepository issues;

    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", books.getBooks());
        return "books";
    }

    @GetMapping("/readers")
    public String getReaders(Model model){
        model.addAttribute("readers", readers.getReaders());
        return "readers";
    }

    @GetMapping("/issues")
    public String getIssues(Model model){
        model.addAttribute("issues", issues.getIssues());
        return "issues";
    }

//    @GetMapping("/reader/{id}")
//    public String getReaderBooksOnHand(@PathVariable long id, Model model){
//        model.addAttribute("user", readers.readerBooksOnHand());
//        return "readers";
//    }
    @GetMapping("/reader/{id}")
    public String getReaderHandBooks(@PathVariable long id, Model model){
        model.addAttribute("issues", issues.getReaderBooksOnHand(id));
        return "readerbookshand";
    }
}
