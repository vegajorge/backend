
package com.proyecto.JLV.Service;

import com.proyecto.JLV.Entity.Persona;
import com.proyecto.JLV.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ImpPersonaService {
    @Autowired
    IPersonaRepository ipersonaRepository;
    
public List <Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne (long id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    public void save (Persona persona){
        ipersonaRepository.save(persona);
    }
    
    public boolean existsById(long id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
    
        public void deletePersona(Long id) {
        ipersonaRepository.deleteById(id);
    }
    public Persona findPersona(Long id) {
        Persona persona = ipersonaRepository.findById(id).orElse(null);
        return persona;
    } 
        
}
