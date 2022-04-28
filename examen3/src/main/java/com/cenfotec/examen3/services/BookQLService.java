package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.repositories.BookQLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookQLService {
    @Autowired
    BookQLRepository bookQLRepository;

    public List<BookQL> getAllBooks(int count) {
        return
                this.bookQLRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<BookQL> getBook(int id) {
        return this.bookQLRepository.findById(id);
    }

    public BookQL createBook(String name, String author, String genre, String status) {
        BookQL book = new BookQL();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setStatus(status);
        return this.bookQLRepository.save(book);
    }

    public void save(BookQL bookEntity) {
        this.bookQLRepository.save(bookEntity);
    }
}
