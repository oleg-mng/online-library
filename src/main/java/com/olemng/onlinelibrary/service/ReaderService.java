package com.olemng.onlinelibrary.service;

import com.olemng.onlinelibrary.model.Book;
import com.olemng.onlinelibrary.model.Reader;
import com.olemng.onlinelibrary.repository.BookRepository;
import com.olemng.onlinelibrary.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> getAllReaders(){
        readerRepository.save(new Reader(1, "Oleg"));
        readerRepository.save(new Reader(2,"Victor"));
        readerRepository.save(new Reader(3,"Leonardo"));

        return readerRepository.findAll();
    }

    public Reader getReaderById(Long id){
        return readerRepository.findReaderById(id);
    }

    public List<Reader> getReaderByName(String name){
        return readerRepository.findReaderByName(name);
    }

    public List<Reader> deleteReaderById(Long id){
        return readerRepository.deleteReaderById(id);
    }

    public List<Reader> saveReader(Long id, String name){
        readerRepository.save(new Reader(id, name));

        return readerRepository.findAll();
    }
}
