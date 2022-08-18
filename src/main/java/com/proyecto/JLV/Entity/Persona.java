
package com.proyecto.JLV.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name="Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    
    @NotNull
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")   
    private String apellido;
    
    @NotNull
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String ubicacion;
    
    @NotNull
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String profecion;
    
    @NotNull
    @Size(min =1, max = 200, message = "no cumple con la longitud requerida")    
    private String descripcion;  
            
    @NotNull
    private String imagen;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
     private List<Educacion> listEducacion;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
     private List<Experiencia> listExperiencia;
   
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
     private List<Proyectos> listProyectos;
      
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
     private List<Skills> listSkills;
         
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
     private List<Redes> listRedes;
   

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String ubicacion, String profecion, String descripcion, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ubicacion = ubicacion;
        this.profecion = profecion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public Persona(String nombre, String apellido, String ubicacion, String profecion, String descripcion, String imagen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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