package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.domain.Parent;
import com.cenfotec.examen3.services.ChildrenService;
import com.cenfotec.examen3.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/parents"})
public class ParentController {
    @Autowired
    private ParentService parentService;

    @Autowired
    private ChildrenService childrenService;

    @GetMapping
    public List getAll() {
        return parentService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Parent> findById(@PathVariable long id) {
        Optional<Parent> result = parentService.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = {"/name_middlename/{nombre}"})
    public ResponseEntity<List<Parent>> findByNameMiddlename(@PathVariable String nombre) {
        List<Parent> result = parentService.findParentsByNombreContains(nombre);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(result);
        }
    }

    @GetMapping(path = {"/family/{id}"})
    public ResponseEntity<Optional<Parent>> findFamily(@PathVariable long id) {
        Optional<Parent> parent = parentService.findById(id);
        List<Children> children = childrenService.findChildrenByIdParent(Math.toIntExact(id));
        parent.get().setChildren(children);
        if (parent.isPresent()) {
            return ResponseEntity.ok().body(parent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Parent create(@RequestBody Parent parent) {
        return parentService.save(parent).get();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Parent> update(@PathVariable("id") long id,
                                         @RequestBody Parent parent) {
        parent.setId(id);
        Optional<Parent> result = parentService.update(parent);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if (parentService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
