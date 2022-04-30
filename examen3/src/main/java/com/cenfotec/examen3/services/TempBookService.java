package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.Parent;
import com.cenfotec.examen3.domain.TempBook;
import com.cenfotec.examen3.repositories.TempBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TempBookService {
    @Autowired
    TempBookRepository tempBookRepository;

    public List<TempBook> getAll() {
        return tempBookRepository.findAll();
    }

    public Optional<TempBook> findById(long id) {
        return tempBookRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }
    public Optional<TempBook> save(TempBook tempBook) {
        return Optional.of(tempBookRepository.save(tempBook));
    }
}
