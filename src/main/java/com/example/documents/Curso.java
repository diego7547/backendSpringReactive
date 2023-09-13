package com.example.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Curso {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Aula aula;

    public Curso() {
    }

    public Curso(String nombre, String descripcion, Aula aula) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.aula = aula;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public enum Aula{
        A01,
        B01,
        C01,
        D01,
        E01
    }
}
