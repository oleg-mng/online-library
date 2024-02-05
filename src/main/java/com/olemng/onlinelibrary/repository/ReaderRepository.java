package com.olemng.onlinelibrary.repository;

import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.model.Reader;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader findReaderById(long id);

    List<Reader> findReaderByName(String name);

    String findReaderNameById(long id);

    List<Reader> deleteReaderById(long id);

//    List<Reader> updateReader(Reader book);
//    List<Reader> findReaders();


}

//
//@Repository
//public class ReaderRepository {
//
//    private final List<Reader> readers;
//
//    public ReaderRepository() {
//        this.readers = new ArrayList<>();
//    }
//
//    @PostConstruct
//    public void generateData() {
//        readers.addAll(List.of(
//                new Reader("Oleg"),
//                new Reader("Victor"),
//                new Reader("Leonardo")
//        ));
//    }
//
//    public Reader getReaderById(long id) {
//        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public String getReaderDescById(long id) {
//        Reader readerDesc = getReaderById(id);
//        return readerDesc.getName();
//    }
//
//    public List<Reader> deleteReaderById(long id) {
//        List<Reader> readersR = readers;
//        Reader readerD = getReaderById(id);
//        readersR.remove(readerD);
//        return readersR;
//    }
//
//    public List<Reader> addReader(Reader reader) {
//        List<Reader> readersR = readers;
//        readersR.add(reader);
//        return readersR;
//    }
//    public List<Reader> getReaders() {
//        return readers;
//    }
//
//    public List<Reader> readerBooksOnHand() {
//        return (List<Reader>) readers.stream().flatMap(s -> Stream.ofNullable(s));
//    }
//
//}