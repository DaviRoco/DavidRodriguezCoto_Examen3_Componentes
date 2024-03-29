package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.BookChildRecord;
import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.domain.Parent;
import com.cenfotec.examen3.services.BookChildRecordService;
import com.cenfotec.examen3.services.ChildrenService;
import com.cenfotec.examen3.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/children"})
public class ChildrenController {

    @Autowired
    private ChildrenService childrenService;
    @Autowired
    private BookChildRecordService bookChildRecordService;
    @Autowired
    private ParentService parentService;

    @GetMapping
    public List getAll() {
        return childrenService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Children> findById(@PathVariable long id) {
        Optional<Children> result = childrenService.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Children create(@RequestBody Children children) {
        Optional<Parent> parent = parentService.findById(children.getIdParent());
        if (parent.isPresent()) {
            return childrenService.save(children).get();
        }
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Children> update(@PathVariable("id") long id,
                                           @RequestBody Children children) {
        children.setId_child(id);
        Optional<BookChildRecord> record;
        Optional<Children> result = childrenService.update(children);
        List<BookChildRecord> records = bookChildRecordService.findByIdChild(id);
        for (BookChildRecord bookRecord : records) {
            record = bookChildRecordService.findById(bookRecord.getId());
            record.get().setNameChild(children.getNombre());
            bookChildRecordService.update(record);
        }

        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (childrenService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
