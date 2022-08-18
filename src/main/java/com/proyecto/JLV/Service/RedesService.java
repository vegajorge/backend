
package com.proyecto.JLV.Service;

import com.proyecto.JLV.Entity.Redes;
import com.proyecto.JLV.Repository.RedesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class RedesService {
    @Autowired
    RedesRepository redesRepository;
    
    public List<Redes> list(){
        return redesRepository.findAll();
    }
    
    public Optional<Redes>getOne(int id){
        return redesRepository.findById(id);
    }
    
    public Optional<Redes> getByNombre(String nombre) {
        return redesRepository.findByNombre(nombre);
                
    }
    
    public void save(Redes redes){
        redesRepository.save(redes);
    }
    
    public void delete(int id){
        redesRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return redesRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return redesRepository.existsByNombre(nombre);
    }
}