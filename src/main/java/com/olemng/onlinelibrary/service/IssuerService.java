package com.olemng.onlinelibrary.service;

import com.olemng.onlinelibrary.api.IssueRequest;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.repository.IssueRepository;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class IssuerService {

    // спринг это все заинжектит
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public Issue issue(IssueRequest request) {
        if (bookRepository.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

        Issue issue = new Issue(request.getBookId(), request.getReaderId());
        issueRepository.save(issue);
        return issue;
    }

    public Issue getIssue(long id) {
        return issueRepository.getIssueById(id);
    }

    public List<Issue> getAllIssueByReader(long id) {
        List<Issue> issueList = new ArrayList<>();
                issueList.addAll(issueRepository.getIssues());
        List<Issue> issueListIdReader = new ArrayList<>();
        for (Issue issue: issueList) {
            if (issue.getReaderId() == id) issueListIdReader.add(issue);

        }

        return issueListIdReader;
    }

}
