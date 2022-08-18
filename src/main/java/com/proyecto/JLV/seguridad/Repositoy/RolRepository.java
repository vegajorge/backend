
package com.proyecto.JLV.seguridad.Repositoy;

import com.proyecto.JLV.seguridad.Entity.Rol;
import com.proyecto.JLV.seguridad.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
