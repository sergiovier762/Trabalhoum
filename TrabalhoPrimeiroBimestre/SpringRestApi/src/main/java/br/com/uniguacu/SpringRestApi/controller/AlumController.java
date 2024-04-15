package br.com.uniguacu.SpringRestApi.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.uniguacu.SpringRestApi.model.Alum;
import br.com.uniguacu.SpringRestApi.service.AlumService;

@RestController
@RequestMapping("/api/v1/alums")
public class AlumController {
    
    @Autowired
    private AlumService alumService;

    //cria o aluno 
    @PostMapping
    public ResponseEntity<Alum> create( @RequestBody Alum alum){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumService.save(alum));
    }
    //busca totos os alunos
    @GetMapping
    public ResponseEntity<List<Alum>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(alumService.findAll());
    }

    //busca por id 
    @GetMapping("/{id}")    
    public ResponseEntity<Optional<Alum>> findById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(alumService.findbyId(id));
    }

    //ataulizar o cadastro do aluno 
    @PutMapping
    public ResponseEntity<Alum> update(@RequestBody Alum alum){
        return ResponseEntity.status(HttpStatus.CREATED).body(alumService.update(alum));
    }
    
    //deleta o aluno 
    @DeleteMapping("/{id}") 
    public ResponseEntity<?> delete(@PathVariable Long id){
        alumService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
