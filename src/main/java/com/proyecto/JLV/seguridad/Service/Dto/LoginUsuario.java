
package com.proyecto.JLV.seguridad.Service.Dto;

import javax.validation.constraints.NotBlank;


public class LoginUsuario {
    
    @NotBlank
    private String nombreUsuario;
    
    @NotBlank
    private String password;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    
}
