
package com.proyecto.JLV.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class PersonaDto {
     
    @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    
    @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")   
    private String apellido;
    
   @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String ubicacion;
    
   @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String profecion;
    
    @NotBlank
    @Size(min =1, max = 200, message = "no cumple con la longitud requerida")    
    private String descripcion;  
            
    @NotBlank
    private String imagen;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String ubicacion, String profecion, String descripcion, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ubicacion = ubicacion;
        this.profecion = profecion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
