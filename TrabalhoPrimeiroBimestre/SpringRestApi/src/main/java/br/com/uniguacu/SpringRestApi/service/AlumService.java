//package br.com.uniguacu.SpringRestApi.service;
//import java.util.List;
//import java.util.Optional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import br.com.uniguacu.SpringRestApi.model.Alum;
//import br.com.uniguacu.SpringRestApi.model.Course;
//import br.com.uniguacu.SpringRestApi.repository.AlumRepository;
//import br.com.uniguacu.SpringRestApi.repository.CourseRepository;
//
//@Service
//public class AlumServiceImpl implements AlumService {
//
//    @Autowired
//    private AlumRepository alumRepository;
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Override
//    public Alum save(Alum alum) {
//        return alumRepository.save(alum);
//    }
//
//    @Override
//    public List<Alum> findAll() {
//        return alumRepository.findAll();
//    }
//
//    @Override
//    public Optional<Alum> findById(Long id) {
//        Optional<Alum> alumOptional = alumRepository.findById(id);
//        if (alumOptional.isPresent()) {
//            // Carregar os dados do curso associado ao aluno
//            Alum alum = alumOptional.get();
//            alum.getCourse(); // Isso irá forçar o carregamento dos dados do curso
//            return Optional.of(alum);
//        } else {
//            return Optional.empty();
//        }
//    }
//
//    @Override
//    public Alum update(Alum alum) {
//        return alumRepository.save(alum);
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        alumRepository.deleteById(id);
//    }
//
//    @Override
//public Alum assignCourse(Long alumId, Long courseId) {
//    // Passo 1: Recuperar o aluno pelo ID
//    Optional<Alum> alumOptional = alumRepository.findById(alumId);
//    if (!alumOptional.isPresent()) {
//        throw new RuntimeException("Alum não encontrado com o id: " + alumId);
//    }
//    Alum alum = alumOptional.get();
//
//    // Passo 2: Recuperar o curso pelo ID
//    Optional<Course> courseOptional = courseRepository.findById(courseId);
//    if (!courseOptional.isPresent()) {
//        throw new RuntimeException("Curso não encontrado com o id: " + courseId);
//    }
//    Course course = courseOptional.get();
//
//    // Passo 3: Atribuir o curso ao aluno
//    alum.setCourse(course);
//
//    // Passo 4: Salvar o aluno atualizado no banco de dados
//    return alumRepository.save(alum);
//}
//
//
//@Override
//public Alum removeCourse(Long alumId) {
//    // Passo 1: Recuperar o aluno pelo ID
//    Optional<Alum> alumOptional = alumRepository.findById(alumId);
//    if (!alumOptional.isPresent()) {
//        throw new RuntimeException("Alum não encontrado com o id: " + alumId);
//    }
//    Alum alum = alumOptional.get();
//
//    // Passo 2: Remover o curso associado ao aluno
//    alum.setCourse(null);
//
//    // Passo 3: Salvar o aluno atualizado no banco de dados
//    return alumRepository.save(alum);
//}
//
//}

package br.com.uniguacu.SpringRestApi.service;
import java.util.List;
import java.util.Optional;
import br.com.uniguacu.SpringRestApi.model.Alum;
// tras as informações e traz as respostas 
public interface AlumService {
        Alum save(Alum alum);
        List<Alum> findAll();
        Optional <Alum> findbyId(Long id);
        Alum update(Alum alum);
        void deleteById(Long id);
        Alum assignCourse(Long alumId, Long courseId);
        Alum removeCourse(Long alumId);
}
