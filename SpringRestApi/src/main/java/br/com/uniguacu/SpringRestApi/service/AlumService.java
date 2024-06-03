package br.com.uniguacu.SpringRestApi.service;

import java.util.List;
import java.util.Optional;
import br.com.uniguacu.SpringRestApi.model.Alum;

public interface AlumService {
    Alum save(Alum alum);
    List<Alum> findAll();
    Optional<Alum> findById(Long id);
    Alum update(Alum alum);
    void deleteById(Long id);
    Alum assignCourse(Long alumId, Long courseId);
    Alum removeCourse(Long alumId, Long courseId);
}
