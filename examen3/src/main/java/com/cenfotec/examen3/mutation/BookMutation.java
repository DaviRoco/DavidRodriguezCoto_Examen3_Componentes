package com.cenfotec.examen3.mutation;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.services.BookService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookMutation implements GraphQLMutationResolver {
    @Autowired
    private BookService bookService;

    public BookQL createBook(String name, String author, String genre, String status) {
        return this.bookService.createBook(name, author, genre, status);
    }

    public BookQL updateBook(int id, String name, String author, String genre, String status) {
        Optional<BookQL> book = this.bookService.getBook(id);
        if (book.isPresent()) {
            BookQL bookEntity = book.get();
            if (name != null)
                bookEntity.setName(name);
            if (author != null)
                bookEntity.setAuthor(author);
            if (genre != null)
                bookEntity.setGenre(genre);
            if (status != null)
                bookEntity.setStatus(status);
            bookService.save(bookEntity);
            return bookEntity;
        }
        return null;
    }

    public BookQL deleteBook(int id) {
        Optional<BookQL> book = this.bookService.getBook(id);
        if (book.isPresent()) {
            BookQL bookEntity = book.get();
            bookEntity.setStatus("Inactivo");
            bookService.save(bookEntity);
            return bookEntity;
        }
        return null;
    }
}