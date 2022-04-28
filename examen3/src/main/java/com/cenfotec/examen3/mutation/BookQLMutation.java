package com.cenfotec.examen3.mutation;

import com.cenfotec.examen3.domain.BookQL;
import com.cenfotec.examen3.services.BookQLService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookQLMutation implements GraphQLMutationResolver {
    @Autowired
    private BookQLService bookQLService;

    public BookQL createBook(String name, String author, String genre, String status) {
        return this.bookQLService.createBook(name, author, genre, status);
    }

    public BookQL updateBook(int id, String name, String author, String genre, String status) {
        Optional<BookQL> book = this.bookQLService.getBook(id);
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
            bookQLService.save(bookEntity);
            return bookEntity;
        }
        return null;
    }

    public BookQL deleteBook(int id) {
        Optional<BookQL> book = this.bookQLService.getBook(id);
        if (book.isPresent()) {
            BookQL bookEntity = book.get();
            bookEntity.setStatus("Inactivo");
            bookQLService.save(bookEntity);
            return bookEntity;
        }
        return null;
    }
}