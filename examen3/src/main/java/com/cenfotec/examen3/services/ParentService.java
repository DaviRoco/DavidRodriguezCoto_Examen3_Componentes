package com.cenfotec.examen3.services;

import com.cenfotec.examen3.domain.Parent;
import com.cenfotec.examen3.repositories.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    ParentRepository parentRepository;

    public List<Parent> getAll() {
        return parentRepository.findAll();
    }

    public Optional<Parent> findById(long id) {
        return parentRepository.findById(id).map(record -> Optional.of(record)).orElse(Optional.empty());
    }

    public Optional<Parent> save(Parent parent) {
        return Optional.of(parentRepository.save(parent));
    }

    public Optional<Parent> update(Parent parent) {
        Optional<Parent> record = parentRepository.findById(parent.getId());
        if (record.isPresent()) {
            Parent data = record.get();
            data.setNombre(parent.getNombre());
            data.setCedula(parent.getCedula());
            data.setDireccion(parent.getDireccion());
            data.setTelefonoPrimario(parent.getTelefonoPrimario());
            data.setTelefonoSecundario(parent.getTelefonoSecundario());
            return Optional.of(parentRepository.save(data));
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        Optional<Parent> result = parentRepository.findById(id);
        if (result.isPresent()) {
            parentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
