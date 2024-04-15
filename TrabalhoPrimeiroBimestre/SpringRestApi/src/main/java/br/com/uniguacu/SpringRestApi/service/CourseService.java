package br.com.uniguacu.SpringRestApi.service;
import java.util.List;
import java.util.Optional;

import br.com.uniguacu.SpringRestApi.model.Alum;
import br.com.uniguacu.SpringRestApi.model.Course;

public interface CourseService {
        Course save(Course course);
        List<Course> findAll();
        Optional <Course> findbyId(Long id);
        Course update(Course course);
        void deleteById(Long id);
        List<Alum> getAlumsByCourse(Long courseId);
} 
