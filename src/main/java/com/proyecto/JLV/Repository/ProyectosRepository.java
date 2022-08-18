
package com.proyecto.JLV.Repository;

import com.proyecto.JLV.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectosRepository extends JpaRepository<Proyectos, Integer>{
    public Optional<Proyectos> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}