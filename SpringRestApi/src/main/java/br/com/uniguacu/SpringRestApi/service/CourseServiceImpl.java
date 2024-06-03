package br.com.uniguacu.SpringRestApi.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.uniguacu.SpringRestApi.model.Alum;
import br.com.uniguacu.SpringRestApi.model.Course;
import br.com.uniguacu.SpringRestApi.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private ICourseRepository corseRepository;

    @Override
    public Course save(Course course) {
        return corseRepository.save(course);
    }
    @Override
    public List<Course> findAll(){
        return corseRepository.findAll();
    }
    @Override
    public Optional <Course> findbyId(Long id){
        return corseRepository.findById(id);
    }
    @Override
    public Course update(Course course){
        return corseRepository.save(course);
    }
    @Override
    public void deleteById(Long id){
        corseRepository.deleteById(id);
// }
// @Override
// public List<Alum> getAlumsByCourse(Long courseId) {
// Optional<Course> optionalCourse = corseRepository.findById(courseId);
//
// if (optionalCourse.isPresent()) {
//     Course course = optionalCourse.get();
//     return course.id;
// } else {
//     
//     return null;
// }
//
    }
    @Override
    public List<Alum> getAlumsByCourse(Long courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAlumsByCourse'");
    }
}