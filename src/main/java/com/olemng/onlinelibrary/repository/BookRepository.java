package com.olemng.onlinelibrary.repository;


import com.olemng.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookById(long id);

    List<Book> findBookByName(String name);

    String findBookNameById(long id);

    void deleteBookById(long id);


}

//@Repository
//public class BookRepository {

//    private final List<Book> books;
//
//    public BookRepository() {
//        this.books = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData() {
//        books.addAll(List.of(
//                new Book("Источник"),
//                new Book("Spring5 для профессионалов "),
//                new Book("чистый код")
//        ));
//    }
//
//    public Book getBookById(long id) {
//        return books.stream().filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public String getBookDescById(long id) {
//        Book bookDesc = getBookById(id);
//        return bookDesc.getName();
//    }
//
//    public List<Book> deleteBookById(long id) {
//        List<Book> booksR = books;
//        Book bookD = getBookById(id);
//        booksR.remove(bookD);
//        return booksR;
//    }
//
//    public List<Book> addBook(Book book) {
//        List<Book> booksR = books;
//        booksR.add(book);
//        return booksR;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }

//}