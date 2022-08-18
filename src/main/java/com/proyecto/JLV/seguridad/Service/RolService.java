
package com.proyecto.JLV.seguridad.Service;

import com.proyecto.JLV.seguridad.Entity.Rol;
import com.proyecto.JLV.seguridad.Enums.RolNombre;
import com.proyecto.JLV.seguridad.Repositoy.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;
    
 public Optional<Rol> getByRolNombre(RolNombre rolNombre){
     return rolRepository.findByRolNombre(rolNombre);
     
 }
    public void save(Rol rol){
        rolRepository.save(rol);
    }
    
    
}
