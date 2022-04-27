package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.services.ChildrenService;
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
        return childrenService.save(children).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Children> update(@PathVariable("id") long id,
                                         @RequestBody Children children) {
        children.setId(id);
        Optional<Children> result = childrenService.update(children);
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
