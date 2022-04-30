package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.BookChildRecord;
import com.cenfotec.examen3.repositories.BookChildRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookChildRecordService {
    @Autowired
    BookChildRecordRepository bookChildRecordRepository;

    public List<BookChildRecord> getAll() {
        return bookChildRecordRepository.findAll();
    }

    public Optional<BookChildRecord> findById(int id) {
        return bookChildRecordRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }
    public List<BookChildRecord> findByIdChild(Long id) {
        return bookChildRecordRepository.findByIdChild(id);
    }
    public Optional<BookChildRecord> save(BookChildRecord bookChildRecord) {
        return Optional.of(bookChildRecordRepository.save(bookChildRecord));
    }

    public Optional<BookChildRecord> update(Optional<BookChildRecord> bookChildRecord) {
        Optional<BookChildRecord> record = bookChildRecordRepository.findById(bookChildRecord.get().getId());
        if (record.isPresent()) {
            BookChildRecord data = record.get();
            data.setIdBook(bookChildRecord.get().getIdBook());
            data.setNameBook(bookChildRecord.get().getNameBook());
            data.setIdChild(bookChildRecord.get().getIdChild());
            data.setNameChild(bookChildRecord.get().getNameChild());
            return Optional.of(bookChildRecordRepository.save(data));
        }
        return Optional.empty();
    }

    public boolean delete(int id) {
        Optional<BookChildRecord> result = bookChildRecordRepository.findById(id);
        if (result.isPresent()) {
            bookChildRecordRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
