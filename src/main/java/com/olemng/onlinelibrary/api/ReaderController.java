package com.olemng.onlinelibrary.api;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import com.olemng.onlinelibrary.service.IssuerService;
import com.olemng.onlinelibrary.service.ReaderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reader")
@Tag(name = "Reader")
public class ReaderController {


    @Autowired
    private ReaderService readerService;

    @Autowired
    private IssuerService issuerService;

    @GetMapping
    @Operation(summary = "Getting all readers", description = "Show all readers in system")
    public List<Reader> getAllReaders() {

        return readerService.getAllReaders();
    }

    @GetMapping("{id}")
    @Operation(summary = "Getting unique reader", description = "Getting unique reader in the system")
    public Reader getBook(@PathVariable long id) {
        return readerService.getReaderById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete the reader by id", description = "Deleting unique reader by id")
    public List<Reader> deleteBook(@PathVariable long id) {
        return readerService.deleteReaderById(id);
    }

    @PostMapping
    @Operation(summary = "Add new reader", description = "Adding new reader in system")
    public List<Reader> addBook(@RequestBody Long id, String name) {
        return readerService.saveReader(id, name);
    }

    //GET /{id}/issue - - вернуть список всех выдачей для данного читателя
    @GetMapping("{id}/issue")
    @Operation(summary = "Get All Issues By Id Reader", description = "Getting All Issues By Id Reader")
    public List<Issue> getAllIssuesByIdReader(@PathVariable long id) {
        return issuerService.getAllIssueByReader(id);
    }

}

