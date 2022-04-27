package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.BookChildRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookChildRecordRepository extends JpaRepository<BookChildRecord, Integer> {
}
