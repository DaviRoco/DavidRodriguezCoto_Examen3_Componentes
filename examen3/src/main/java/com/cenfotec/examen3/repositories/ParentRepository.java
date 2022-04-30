package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
    Optional<Parent> findParentByNombreContains(@Param("nombre") String nombre);
}
