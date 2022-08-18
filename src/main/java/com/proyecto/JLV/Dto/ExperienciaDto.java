
package com.proyecto.JLV.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;



public class ExperienciaDto {
    @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    @NotBlank
    @Size(min =1, max = 60, message = "no cumple con la longitud requerida")
    private String descripcion;
    

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
