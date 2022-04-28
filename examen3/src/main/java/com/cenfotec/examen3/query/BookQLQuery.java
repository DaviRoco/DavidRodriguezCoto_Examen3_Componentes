package com.cenfotec.examen3.query;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.services.BookQLService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQLQuery implements GraphQLQueryResolver {
    @Autowired
    private BookQLService bookQLService;

    public List<BookQL> getBooks(int count) {
        return this.bookQLService.getAllBooks(count);
    }

    public Optional<BookQL> getBook(int id) {
        return this.bookQLService.getBook(id);
    }
}
