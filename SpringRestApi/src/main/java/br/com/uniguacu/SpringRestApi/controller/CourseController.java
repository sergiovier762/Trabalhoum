package br.com.uniguacu.SpringRestApi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.uniguacu.SpringRestApi.model.Course;
import br.com.uniguacu.SpringRestApi.service.CourseService;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Course>> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findbyId(id));
    }

    @PutMapping
    public ResponseEntity<Course> update(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.update(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
