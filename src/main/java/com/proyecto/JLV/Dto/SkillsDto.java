
package com.proyecto.JLV.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class SkillsDto {
    @NotBlank
    @Size(min =1, max = 50, message = "no cumple con la longitud requerida")
    private String nombre;
    @NotBlank
    private int porcentaje; 

    public SkillsDto() {
    }

    public SkillsDto(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
