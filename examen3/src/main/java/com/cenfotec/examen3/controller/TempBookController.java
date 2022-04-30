package com.cenfotec.examen3.controller;

import com.cenfotec.examen3.domain.Parent;
import com.cenfotec.examen3.domain.TempBook;
import com.cenfotec.examen3.services.ParentService;
import com.cenfotec.examen3.services.TempBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"/tempbook"})
public class TempBookController {
    @Autowired
    private TempBookService tempBookService;

    @GetMapping
    public List getAll() {
        return tempBookService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TempBook> findById(@PathVariable long id) {
        Optional<TempBook> result = tempBookService.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public TempBook create(@RequestBody TempBook tempBook) {
        return tempBookService.save(tempBook).get();
    }
}
