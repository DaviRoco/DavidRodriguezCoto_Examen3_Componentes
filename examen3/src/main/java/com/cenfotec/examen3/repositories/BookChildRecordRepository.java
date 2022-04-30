package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.BookChildRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookChildRecordRepository extends JpaRepository<BookChildRecord, Integer> {
    List<BookChildRecord> findByIdChild(Long id);
}
