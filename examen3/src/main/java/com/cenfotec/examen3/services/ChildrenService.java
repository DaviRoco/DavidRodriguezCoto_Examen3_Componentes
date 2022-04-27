package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.Children;
import com.cenfotec.examen3.repositories.ChildrenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChildrenService {
    @Autowired
    ChildrenRepository childrenRepository;

    public List<Children> getAll() {
        return childrenRepository.findAll();
    }

    public Optional<Children> findById(long id) {
        return childrenRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    public Optional<Children> save(Children children) {
        return Optional.of(childrenRepository.save(children));
    }

    public Optional<Children> update(Children children) {
        Optional<Children> record = childrenRepository.findById(children.getId());
        if (record.isPresent()) {
            Children data = record.get();
            data.setNombre(children.getNombre());
            data.setPlanUsuario(children.getPlanUsuario());
            data.setAlergias(children.getAlergias());
            data.setIdParent(children.getIdParent());
            return Optional.of(childrenRepository.save(data));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        Optional<Children> result = childrenRepository.findById(id);
        if (result.isPresent()) {
            childrenRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
