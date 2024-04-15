package br.com.uniguacu.SpringRestApi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.uniguacu.SpringRestApi.model.Course;

public interface ICourseRepository extends JpaRepository <Course, Long> {
    
}