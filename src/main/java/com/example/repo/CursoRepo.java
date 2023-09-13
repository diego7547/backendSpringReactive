package com.example.repo;

import com.example.documents.Curso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CursoRepo extends ReactiveMongoRepository<Curso,String> {

    Mono<Curso> findFirstByNombre(String nombre);

}
