
package com.proyecto.JLV.Service;

import com.proyecto.JLV.Entity.Proyectos;
import com.proyecto.JLV.Repository.ProyectosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class ProyectosService {
    @Autowired
    ProyectosRepository proyectosRepository;
    
    public List<Proyectos> list(){
        return proyectosRepository.findAll();
    }
    
    public Optional<Proyectos>getOne(int id){
        return proyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre) {
        return proyectosRepository.findByNombre(nombre);
                
    }
    
    public void save(Proyectos proyectos){
        proyectosRepository.save(proyectos);
    }
    
    public void delete(int id){
        proyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return proyectosRepository.existsByNombre(nombre);
    }
}
