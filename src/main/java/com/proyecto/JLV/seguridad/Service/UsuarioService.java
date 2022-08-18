
package com.proyecto.JLV.seguridad.Service;

import com.proyecto.JLV.seguridad.Entity.Usuario;
import com.proyecto.JLV.seguridad.Repositoy.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
  
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
       
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
   public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    } 
   
   public void save(Usuario usuario){
       usuarioRepository.save(usuario);
   }
}
