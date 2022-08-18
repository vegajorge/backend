package com.proyecto.JLV.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="Proyectos")
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    @Size(min =1, max = 60, message = "no cumple con la longitud requerida")
    private String descripcion; 

    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
 }