package br.com.uniguacu.SpringRestApi.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.uniguacu.SpringRestApi.model.Alum;
import br.com.uniguacu.SpringRestApi.model.Course;
import br.com.uniguacu.SpringRestApi.repository.IAlumRepository;
import br.com.uniguacu.SpringRestApi.repository.ICourseRepository;

@Service
public class AlumServiceImpl implements AlumService {
    @Autowired
    private IAlumRepository alumRepository;
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Alum save(Alum alum) {
        return alumRepository.save(alum);
    }

    @Override
    public List<Alum> findAll() {
        return alumRepository.findAll();
    }

    @Override
    public Optional<Alum> findById(Long id) {
        return alumRepository.findById(id);
    }

    @Override
    public Alum update(Alum alum) {
        return alumRepository.save(alum);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Alum> optionalAlum = alumRepository.findById(id);
        if (optionalAlum.isPresent()) {
            Alum alum = optionalAlum.get();
            alum.getCourses().clear();
            alumRepository.save(alum);
            alumRepository.deleteById(id);
        } else {
            throw new RuntimeException("Alum not found");
        }
    }

    @Override
    public Alum assignCourse(Long alumId, Long courseId) {
        Optional<Alum> optionalAlum = alumRepository.findById(alumId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalAlum.isPresent() && optionalCourse.isPresent()) {
            Alum alum = optionalAlum.get();
            Course course = optionalCourse.get();
            alum.getCourses().add(course);
            alumRepository.save(alum);
            return alum;
        } else {
            throw new RuntimeException("Alum or Course not found");
        }
    }

    @Override
    public Alum removeCourse(Long alumId, Long courseId) {
        Optional<Alum> optionalAlum = alumRepository.findById(alumId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalAlum.isPresent() && optionalCourse.isPresent()) {
            Alum alum = optionalAlum.get();
            Course course = optionalCourse.get();
            alum.getCourses().remove(course);
            alumRepository.save(alum);
            return alum;
        } else {
            throw new RuntimeException("Alum or Course not found");
        }
    }
}
