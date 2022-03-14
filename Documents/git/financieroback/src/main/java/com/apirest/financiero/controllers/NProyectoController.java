package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NProyecto;
import com.apirest.financiero.models.services.NProyectoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class NProyectoController {
  
  @Autowired
  private NProyectoService nProyectoService;
  
  @GetMapping("/proyecto/list")
  public List<NProyecto> findAll(){
    return nProyectoService.findAll();
  }
  
  @GetMapping("/proyecto/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Short id){
    NProyecto nProyecto = null;
    Map<String, Object> response = new HashMap<>();
    
    try{
      nProyecto = nProyectoService.findById(id);
    }catch (DataAccessException e){
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    if(nProyecto == null){
      response.put("mensaje", "El Proyecto con el Id: ".concat(id.toString().concat(" No Existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<NProyecto>(nProyecto, HttpStatus.OK);
  }
  
  @PostMapping("/proyecto/new")
  public ResponseEntity<?> create(@RequestBody NProyecto nProyecto){
    NProyecto nProyectoNew = null;
    
    Map<String, Object> response  = new HashMap<>();
    
    try {
      nProyectoNew = nProyectoService.save(nProyecto);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Proyecto ha sido creado con éxito!");
    response.put("proyecto", nProyectoNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/proyecto/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Short id, @RequestBody NProyecto nProyecto){
    
    NProyecto nProyectoActual = nProyectoService.findById(id);
    NProyecto nProyectoUpdated = null;
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if (nProyectoActual == null) {
      response.put("mensaje", "error: no se puede editar, el proyecto con el ID: ".concat(id.toString().concat(" No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    try {
      nProyectoActual.setCodigoProyecto(nProyecto.getCodigoProyecto());
      nProyectoActual.setNombreProyecto(nProyecto.getNombreProyecto());
      nProyectoActual.setSiglaProyecto(nProyecto.getSiglaProyecto());
      nProyectoActual.setCodigoRel(nProyecto.getCodigoRel());
      
      nProyectoUpdated = nProyectoService.save(nProyectoActual);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el proyecto");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Proyecto con el ID: ".concat(nProyectoUpdated.getCodigoProyecto().toString().concat(" ha sido actualizado con éxito!")));
    response.put("proyecto", nProyectoUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("proyecto/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Short id){
    Map<String, Object> response = new HashMap<>();
    NProyecto nProyecto = nProyectoService.findById(id);
    try {
      if (nProyecto == null) {
        response.put("error", "Error al Eliminar el proyecto con el ID: ".concat(id.toString().concat(" No Existe")));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }
      nProyectoService.delete(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el proyecto");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    response.put("mensaje", "El Proyecto con el ID: ".concat(id.toString().concat(" ha sido eliminado con éxito!")));
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
