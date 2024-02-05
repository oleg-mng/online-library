package com.olemng.onlinelibrary.repository;

import com.olemng.onlinelibrary.model.Issue;
import com.olemng.onlinelibrary.model.Reader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{

//    List<Issue> updateIssueById(long id);
//    List<Issue> save(long id);
    List<Issue> findAll();

    Issue findIssueById(long id);




}
//
//@Repository
//public class IssueRepository {
//
//    private final List<Issue> issues;
//
//    public IssueRepository() {
//        this.issues = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData() {
//        issues.addAll(List.of(
//                new Issue(1, 2, LocalDateTime.now().minusDays(2)),
//                new Issue(2, 3, LocalDateTime.now().minusDays(1)),
//                new Issue(3, 2, null),
//                new Issue(4, 2, null),
//                new Issue(9, 2, LocalDateTime.now().minusDays(2)),
//                new Issue(7, 3, LocalDateTime.now().minusDays(1))
//
//        ));
//    }
//
//    public void save(Issue issue) {
//        // insert into ....
//        issues.add(issue);
//    }
//
//    public Issue getIssueById(long id) {
//        return issues.stream().filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public List<Issue> getIssues() {
//        return issues;
//    }
//
//    public List<Issue> getReaderBooksOnHand(long id) {
//        List<Issue> issueList = new ArrayList<>();
//        for (Issue is : issues) {
//            if (is.getReaderId() == id && is.getDueDate() == null) {
//                issueList.add(is);
//            }
//        }
//        return issueList;
//    }
//
//}
