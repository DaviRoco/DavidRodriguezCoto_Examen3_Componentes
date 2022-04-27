package com.cenfotec.examen3.mutation;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation {
    @Autowired
    private BookService bookService;

    public BookQL createBook(String name, String author, String genre) {
        return this.bookService.createBook(name, author, genre);
    }
}
