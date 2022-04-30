package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.TempBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TempBookRepository extends JpaRepository<TempBook, Long> {
}
