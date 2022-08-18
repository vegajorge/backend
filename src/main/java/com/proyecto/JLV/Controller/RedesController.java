
package com.proyecto.JLV.Controller;

import com.proyecto.JLV.Dto.RedesDto;
import com.proyecto.JLV.Entity.Redes;
import com.proyecto.JLV.Service.RedesService;
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
@RequestMapping("/redes/")
@CrossOrigin(origins = "http://localhost:4200")
public class RedesController {
    @Autowired
    RedesService redesService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Redes>> list(){
        List<Redes> list = redesService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") int id){
        if(!redesService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Redes redes = redesService.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!redesService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        redesService.delete(id);
        return new ResponseEntity(new Mensaje("red social eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody RedesDto dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(redesService.existsByNombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("Esa red social ya existe"), HttpStatus.BAD_REQUEST);
        
        Redes redes = new Redes(dtoexp.getNombre(),dtoexp.getDescripcion());
        redesService.save(redes);
        
        return new ResponseEntity(new Mensaje("red social agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody RedesDto dtoexp){
        if(!redesService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(redesService.existsByNombre(dtoexp.getNombre()) && redesService.getByNombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa red social ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Redes redes = redesService.getOne(id).get();
        redes.setNombre(dtoexp.getNombre());
        redes.setDescripcion(dtoexp.getDescripcion());
        
        redesService.save(redes);
        return new ResponseEntity(new Mensaje("red social actualizada"), HttpStatus.OK);
             
    }
}