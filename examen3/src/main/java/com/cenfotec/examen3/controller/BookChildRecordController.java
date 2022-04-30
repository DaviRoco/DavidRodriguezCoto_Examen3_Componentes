package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.BookChildRecord;
import com.cenfotec.examen3.domain.TempBook;
import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.services.BookChildRecordService;
import com.cenfotec.examen3.services.ChildrenService;
import com.cenfotec.examen3.services.TempBookService;
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
    @Autowired
    private TempBookService tempBookService;

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
    public ResponseEntity<List<Optional<TempBook>>> findByChild(@PathVariable long id) {
        List<BookChildRecord> bookChildRecords = bookChildRecordService.findByIdChild(id);
        List<Optional<TempBook>> result = new ArrayList<>();
        Optional<TempBook> book;
        for (BookChildRecord bookChildRecord : bookChildRecords) {
            book = tempBookService.findById(bookChildRecord.getIdBook());
            if (book.isPresent()){
                result.add(book);
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
        ArrayList<String> childrenBookCount = new ArrayList<>();
        List<Children> children = childrenService.getAll();
        for (Children child : children) {
            childrenBookCount.add("Identificación: " + child.getId_child() + ", Nombre: " + child.getNombre() + ", cantidad de libros leídos: " + bookChildRecordService.countAllByIdChild(child.getId_child()));
        }
        if (childrenBookCount.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(childrenBookCount);
        }
    }

    @PostMapping
    public BookChildRecord create(@RequestBody BookChildRecord bookChildRecord) {
        Optional<Children> child = childrenService.findById(bookChildRecord.getIdChild());
        Optional<TempBook> book = tempBookService.findById(bookChildRecord.getIdBook());
        if (child.isPresent() && book.isPresent()){
            bookChildRecord.setNameBook(book.get().getName());
            bookChildRecord.setNameChild(child.get().getNombre());
            return bookChildRecordService.save(bookChildRecord).get();
        }
        return null;
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
