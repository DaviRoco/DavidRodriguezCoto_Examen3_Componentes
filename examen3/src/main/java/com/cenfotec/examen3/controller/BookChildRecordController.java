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

    @GetMapping(path = {"/child/{id}"})
    public ResponseEntity<List<Books>> findByChild(@PathVariable int id) {
        ArrayList<Books> libros = createTempBooks();
        Optional<Children> child = childrenService.findById(id);
        List<BookChildRecord> bookChildRecords = bookChildRecordService.getAll();
        List<Books> result = new ArrayList<>();
        for (Books book : libros) {
            for (BookChildRecord bookChildRecord : bookChildRecords) {
                if (bookChildRecord.getIdBook() == book.getId() && bookChildRecord.getIdChild() == id) {
                    result.add(book);
                }
            }
        }
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(result);
        }
    }

    @GetMapping(path = {"/childrenBookcount"})
    public ResponseEntity<ArrayList<String>> getBookCount() {
        int i = 0;
        ArrayList<String> childrenBookCount = new ArrayList<>();
        List<Children> children = childrenService.getAll();
        List<BookChildRecord> bookChildRecords = bookChildRecordService.getAll();
        for (Children child : children) {
            for (BookChildRecord bookChildRecord : bookChildRecords) {
                if (bookChildRecord.getIdChild().equals(child.getId())) {
                    i++;
                }
            }
            childrenBookCount.add("Identificación: " + child.getId() + ", Nombre: " + child.getNombre() + ", cantidad de libros leídos: " + i);
            i = 0;
        }
        if (childrenBookCount.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(childrenBookCount);
        }
    }

    @PostMapping
    public BookChildRecord create(@RequestBody BookChildRecord bookChildRecord) {
        ArrayList<Books> libros = createTempBooks();
        Optional<Children> child = childrenService.findById(bookChildRecord.getIdChild());
        for (int i = 0; i < libros.size(); i++) {
            if (bookChildRecord.getIdBook() == libros.get(i).getId() && child.isPresent()) {
                bookChildRecord.setNameBook(libros.get(i).getName());
                bookChildRecord.setNameChild(child.get().getNombre());
                return bookChildRecordService.save(bookChildRecord).get();
            }
        }
        return null;
    }

    private ArrayList<Books> createTempBooks() {
        ArrayList<Books> libros = new ArrayList<Books>() {
        };
        libros.add(new Books(1, "Libro1", "test", "test"));
        libros.add(new Books(2, "Libro2", "test", "test"));
        libros.add(new Books(3, "Libro3", "test", "test"));
        libros.add(new Books(4, "Libro4", "test", "test"));
        libros.add(new Books(5, "Libro5", "test", "test"));

        return libros;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (bookChildRecordService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
