package com.olemng.onlinelibrary.repository;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Reader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

    private final List<Reader> readers;

    public ReaderRepository() {
        this.readers = new ArrayList<>();
    }

    @PostConstruct
    public void generateData() {
        readers.addAll(List.of(
                new Reader("Oleg"),
                new Reader("Victor"),
                new Reader("Leonardo")
        ));
    }

    public Reader getReaderById(long id) {
        return readers.stream().filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public String getReaderDescById(long id) {
        Reader readerDesc = getReaderById(id);
        return readerDesc.getName();
    }

    public List<Reader> deleteReaderById(long id) {
        List<Reader> readersR = readers;
        Reader readerD = getReaderById(id);
        readersR.remove(readerD);
        return readersR;
    }

    public List<Reader> addReader(Reader reader) {
        List<Reader> readersR = readers;
        readersR.add(reader);
        return readersR;
    }
    public List<Reader> getReaders() {
        return readers;
    }

}