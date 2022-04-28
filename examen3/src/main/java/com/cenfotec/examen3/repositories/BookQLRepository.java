package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.BookQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQLRepository extends JpaRepository<BookQL, Integer> {
}
