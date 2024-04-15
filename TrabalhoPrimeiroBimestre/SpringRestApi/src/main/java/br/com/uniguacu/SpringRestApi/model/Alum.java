package br.com.uniguacu.SpringRestApi.model;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
//import br.com.uniguacu.SpringRestApi.model.Course;

@Entity
@Data
public class Alum {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;
    private Date datebirth;
    private String address;
    private String teste;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}