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
public class AlumServiceImpl implements AlumService{
    @Autowired
    private IAlumRepository alumRepository;
    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Alum save(Alum alum) {
        return alumRepository.save(alum);
    }
    @Override
    public List<Alum> findAll(){
        return alumRepository.findAll();
    }

    @Override
    public Optional <Alum> findbyId(Long id){
        return alumRepository.findById(id);
    }

    @Override
    public Alum update(Alum alum){
        return alumRepository.save(alum);
    }

    @Override
    public void deleteById(Long id){
        alumRepository.deleteById(id);
    }
    //entrada do aluno no curso
    public Alum assignCourse(Long alumId, Long courseId) {
        Optional<Alum> optionalAlum = alumRepository.findById(alumId);
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalAlum.isPresent() && optionalCourse.isPresent()) {
            Alum alum = optionalAlum.get();
            Course course = optionalCourse.get();

            alum.setCourse(course);
            return alumRepository.save(alum);
        } else {
            return null;
        }
    }
    @Override
    public Alum removeCourse(Long alumId) {
        Optional<Alum> optionalAlum = alumRepository.findById(alumId);

        if (optionalAlum.isPresent()) {
            Alum alum = optionalAlum.get();
            alum.setCourse(null);
            return alumRepository.save(alum);
        } else {
        return null;
        }
    }
}