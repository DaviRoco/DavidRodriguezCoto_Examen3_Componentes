package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.BookQL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookQL, Integer> {
}
