
package com.proyecto.JLV.Controller;

import com.proyecto.JLV.Dto.ProyectosDto;
import com.proyecto.JLV.Entity.Proyectos;
import com.proyecto.JLV.Service.ProyectosService;
import com.proyecto.JLV.seguridad.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/proyectos/")
@CrossOrigin(origins = "http://localhost:4200")

public class ProyectosController {
    
    @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = proyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody ProyectosDto dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectosService.existsByNombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("Ese Proyectos existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new Proyectos(dtoexp.getNombre(),dtoexp.getDescripcion());
        proyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectosDto dtoexp){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(proyectosService.existsByNombre(dtoexp.getNombre()) && proyectosService.getByNombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = proyectosService.getOne(id).get();
        proyectos.setNombre(dtoexp.getNombre());
        proyectos.setDescripcion(dtoexp.getDescripcion());
        
        proyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
}