package br.com.uniguacu.SpringRestApi.model;

import java.sql.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties("alums")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String description;
    private Date dateini;
    private Date datefim;
    private String local;

    @ManyToMany(mappedBy = "courses")
    private Set<Alum> alums;
}
