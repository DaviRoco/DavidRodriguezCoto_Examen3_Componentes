package com.cenfotec.examen3.repositories;

import com.cenfotec.examen3.domain.Children;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildrenRepository extends JpaRepository<Children, Long> {
    List<Children> findChildrenByIdParent(@Param("id") int id);
}
