package com.cenfotec.examen3.query;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.services.BookService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookQuery implements GraphQLQueryResolver {
    @Autowired
    private BookService bookService;
    public List<BookQL> getBooks(int count) {
        return this.bookService.getAllBooks(count);
    }
    public Optional<BookQL> getBook(int id) {
        return this.bookService.getBook(id);
    }
}
