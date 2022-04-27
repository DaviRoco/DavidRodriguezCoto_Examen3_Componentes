package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.Book;
import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<BookQL> getAllBooks(int count) {
        return
                this.bookRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<BookQL> getBook(int id) {
        return this.bookRepository.findById(id);
    }

    public BookQL createBook(String name, String author, String genre) {
        BookQL book = new BookQL();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);
        return this.bookRepository.save(book);
    }
}
