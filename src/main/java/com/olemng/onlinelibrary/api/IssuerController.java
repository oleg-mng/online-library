package com.olemng.onlinelibrary.api;


import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.service.IssuerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/issue")
@Tag(name = "Issue")
public class IssuerController {

    @Autowired
    private IssuerService service;

    @GetMapping
    @Operation(summary = "Get all issues", description = "Getting all issues in system")
    public String getList(Model model) {
        model.addAttribute("issues", service.getAllIssues());
        return "issues";
    }

//  @PutMapping
//  public void returnBook(long issueId) {
//    // найти в репозитории выдачу и проставить ей returned_at
//  }

//    @PostMapping
//    public ResponseEntity<Issue> issueBook(@RequestBody IssueRequest request) {
//        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
//
//        final Issue issue;
//        try {
//            issue = service.issue(request);
//        } catch (NoSuchElementException e) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(issue);
//    }

    //GET /issue/{id}
    @GetMapping({"/{id}"})
    @Operation(summary = "Get issue By Id", description = "Getting issue by Id")
    public Issue getIssueDesc(@PathVariable long id) {
        return service.getIssue(id);

    }

}
