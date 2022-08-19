
package com.proyecto.JLV.Controller;
import com.proyecto.JLV.Dto.PersonaDto;
import com.proyecto.JLV.Entity.Persona;
import com.proyecto.JLV.Service.ImpPersonaService;
import com.proyecto.JLV.seguridad.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/personas/")
@CrossOrigin(origins = "https://frond-endjorge.web.app")
public class PersonaController {
    @Autowired ImpPersonaService impPersonaService;
       
    
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        impPersonaService.deletePersona(id);
        return "Se borro la Persona";
    }
      
    @GetMapping("/lista/perfil")
    public Persona findPersona (){
        return impPersonaService.findPersona((long)1);
    }
    
   @GetMapping("/lista")
    public ResponseEntity<List< Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/nueva")
    public String createPersona(@RequestBody Persona persona) {
        impPersonaService.save(persona);
        return "El usuario fue creado correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonaDto dtopers) {
   
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
   
        if (impPersonaService.existsByNombre(dtopers.getNombre()) && impPersonaService.getByNombre(dtopers.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
       
        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getOne(id).get();
        persona.setNombre(dtopers.getNombre());
        persona.setApellido(dtopers.getApellido());
        persona.setUbicacion(dtopers.getUbicacion());
        persona.setProfecion(dtopers.getProfecion());
        persona.setDescripcion(dtopers.getDescripcion());
        persona.setImagen(dtopers.getImagen());

        impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizado"), HttpStatus.OK);
    }

} 