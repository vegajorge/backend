
package com.proyecto.JLV.Repository;

import com.proyecto.JLV.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{
    public Optional<Experiencia> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
    
}

