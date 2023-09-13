package com.example.controller;

import com.example.documents.Curso;
import com.example.repo.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class CursoController {

    @Autowired
    private CursoRepo cursoRepo;

    @GetMapping("/list-curso")
    public Flux<Curso> listaCurso(){
        return cursoRepo.findAll();
    }

    @GetMapping("/curso/{id}")
    public Mono<ResponseEntity<Curso>> obtenerCurso(@PathVariable String id){
        return cursoRepo.findById(id).map(curso -> new ResponseEntity<>(curso, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/save")
    public Mono<ResponseEntity<Curso>> saveCurso(@RequestBody Curso curso){
        return cursoRepo.insert(curso)
                .map(data -> new ResponseEntity<>(data,HttpStatus.ACCEPTED))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE));
    }


    @PutMapping("/edit/{id}")
    public Mono<ResponseEntity<Curso>> editCurso(@RequestBody Curso curso,@PathVariable String id){
        return cursoRepo.findById(id).flatMap(dataUpdate -> {
           curso.setId(id);
            return cursoRepo.save(curso)
                    .map(curso1 -> new ResponseEntity<>(curso1,HttpStatus.ACCEPTED));
        }).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> eliminarCurso(@PathVariable String id){
         return cursoRepo.deleteById(id);
    }


}
