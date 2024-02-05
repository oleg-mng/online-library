package com.olemng.onlinelibrary.service;

import com.olemng.onlinelibrary.api.IssueRequest;
import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.repository.IssueRepository;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssuerService {

    // спринг это все заинжектит
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;
    private final IssueRepository issueRepository;

    public List<Issue> getAllIssues() {
        issueRepository.save(new Issue(1, 1, 2, LocalDateTime.now().minusDays(2)));
        issueRepository.save(new Issue(2, 2, 3, LocalDateTime.now().minusDays(1)));
        issueRepository.save(new Issue(3, 3, 2, null));
        issueRepository.save(new Issue(4, 4, 2, null));
        issueRepository.save(new Issue(5, 9, 2, LocalDateTime.now().minusDays(2)));
        issueRepository.save(new Issue(6, 7, 3, LocalDateTime.now().minusDays(1)));

        return issueRepository.findAll();
}


    public Issue issue(IssueRequest request) {
        if (bookRepository.findBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerRepository.findReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        // можно проверить, что у читателя нет книг на руках (или его лимит не превышает в Х книг)

        Issue issue = new Issue(request.getId(), request.getBookId(), request.getReaderId(), request.getDueDate);
        issueRepository.save(issue);
        return issue;
    }

    public Issue getIssue(long id) {
        return issueRepository.findIssueById(id);
    }

    public List<Issue> getAllIssueByReader(long id) {
        List<Issue> issueList = new ArrayList<>();
        issueList.addAll(issueRepository.findAll());
        List<Issue> issueListIdReader = new ArrayList<>();
        for (Issue issue : issueList) {
            if (issue.getReaderId() == id) issueListIdReader.add(issue);

        }

        return issueListIdReader;
    }

}
