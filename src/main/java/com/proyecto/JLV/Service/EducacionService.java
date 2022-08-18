
package com.proyecto.JLV.Service;

import com.proyecto.JLV.Entity.Educacion;
import com.proyecto.JLV.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class EducacionService {
    @Autowired
    EducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion>getOne(int id){
        return educacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombre(String nombre) {
        return educacionRepository.findByNombre(nombre);
                
    }
    
    public void save(Educacion experiencia){
        educacionRepository.save(experiencia);
    }
    
    public void delete(int id){
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return educacionRepository.existsByNombre(nombre);
    }
}