
package com.proyecto.JLV.Repository;

import com.proyecto.JLV.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<Redes, Integer>{
    public Optional<Redes> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
