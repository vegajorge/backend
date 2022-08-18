
package com.proyecto.JLV.Repository;

import com.proyecto.JLV.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Integer>{
    public Optional<Educacion> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
