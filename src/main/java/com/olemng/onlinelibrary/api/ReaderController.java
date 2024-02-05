package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import com.olemng.onlinelibrary.service.IssuerService;
import com.olemng.onlinelibrary.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reader")
public class ReaderController {


    @Autowired
    private ReaderService readerService;

    @Autowired
    private IssuerService issuerService;

    @GetMapping
    public List<Reader> getAllReaders() {

        return readerService.getAllReaders();
    }

    @GetMapping("{id}")
    public Reader getBook(@PathVariable long id) {
        return readerService.getReaderById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<Reader> deleteBook(@PathVariable long id) {
        return readerService.deleteReaderById(id);
    }

    @PostMapping
    public List<Reader> addBook(@RequestBody Long id, String name) {
        return readerService.saveReader(id, name);
    }

    //GET /{id}/issue - - вернуть список всех выдачей для данного читателя
    @GetMapping("{id}/issue")
    public List<Issue> getAllIssuesByIdReader(@PathVariable long id) {
        return issuerService.getAllIssueByReader(id);
    }

}

