package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import com.olemng.onlinelibrary.service.IssuerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reader")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;
    @Autowired
    private IssuerService issuerService;

    @GetMapping("{id}")
    public String getBook(@PathVariable long id){
        return readerRepository.getReaderDescById(id);
    }

    @DeleteMapping("{id}")
    public List<Reader> deleteBook(@PathVariable long id){
        return readerRepository.deleteReaderById(id);
    }

    @PostMapping
    public List<Reader> addBook(@RequestBody Reader reader){
        return readerRepository.addReader(reader);
    }

    //GET /{id}/issue - - вернуть список всех выдачей для данного читателя
    @GetMapping("{id}/issue")
    public List<Issue> getAllIssuesByIdReader(@PathVariable long id){
        return issuerService.getAllIssueByReader(id);
    }

}

