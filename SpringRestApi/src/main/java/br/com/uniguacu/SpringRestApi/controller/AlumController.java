package br.com.uniguacu.SpringRestApi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.uniguacu.SpringRestApi.model.Alum;
import br.com.uniguacu.SpringRestApi.service.AlumService;

@RestController
@RequestMapping("/api/v1/alums")
public class AlumController {

    @Autowired
    private AlumService alumService;

    @PostMapping
    public ResponseEntity<Alum> create(@RequestBody Alum alum) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumService.save(alum));
    }

    @GetMapping
    public ResponseEntity<List<Alum>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(alumService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Alum>> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(alumService.findById(id));
    }

    @PutMapping
    public ResponseEntity<Alum> update(@RequestBody Alum alum) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alumService.update(alum));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        alumService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/{alumId}/courses/{courseId}")
    public ResponseEntity<Alum> assignCourse(@PathVariable Long alumId, @PathVariable Long courseId) {
        try {
            Alum updatedAlum = alumService.assignCourse(alumId, courseId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedAlum);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{alumId}/courses/{courseId}")
    public ResponseEntity<Alum> removeCourse(@PathVariable Long alumId, @PathVariable Long courseId) {
        try {
            Alum updatedAlum = alumService.removeCourse(alumId, courseId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedAlum);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
