package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.BookChildRecord;
import com.cenfotec.examen3.domain.Books;
import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.services.BookChildRecordService;
import com.cenfotec.examen3.services.ChildrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/records"})
public class BookChildRecordController {
    @Autowired
    private BookChildRecordService bookChildRecordService;
    @Autowired
    private ChildrenService childrenService;

    @GetMapping
    public List getAll() {
        return bookChildRecordService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<BookChildRecord> findById(@PathVariable int id) {
        Optional<BookChildRecord> result = bookChildRecordService.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public BookChildRecord create(@RequestBody BookChildRecord bookChildRecord) {
        ArrayList<Books> libros = new ArrayList<Books>(){};
        libros.add(new Books(1, "Libro1", "test", "test"));
        libros.add(new Books(2, "Libro2", "test", "test"));
        libros.add(new Books(3, "Libro3", "test", "test"));
        libros.add(new Books(4, "Libro4", "test", "test"));
        libros.add(new Books(5, "Libro5", "test", "test"));
        Optional<Children> child = childrenService.findById(bookChildRecord.getIdChild());
        for (int i = 0; i < libros.size(); i++){
            if (bookChildRecord.getIdBook() == libros.get(i).getId() && child.isPresent()){
                bookChildRecord.setNameBook(libros.get(i).getName());
                bookChildRecord.setNameChild(child.get().getNombre());
                return bookChildRecordService.save(bookChildRecord).get();
            }
        }
        return null;
    }
}
