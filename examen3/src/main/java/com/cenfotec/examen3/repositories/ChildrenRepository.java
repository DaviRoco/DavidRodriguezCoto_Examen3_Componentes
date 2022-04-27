package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
}
