package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NRiesgoPorcentaje;
import com.apirest.financiero.models.services.NRiesgoPorcentajeService;
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
public class NRiesgoPorcentajeController {
  
  @Autowired
  private NRiesgoPorcentajeService nRiesgoPorService;
  
  
  @GetMapping("/riesgoporcentaje/list")
  public List<NRiesgoPorcentaje> findAll(){
    return nRiesgoPorService.findAll();
  }
  
  @GetMapping("/riesgoporcentaje/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Short id){
    NRiesgoPorcentaje nRiesgo = null;
    Map<String, Object> response = new HashMap<>();
    
    try{
      nRiesgo = nRiesgoPorService.findById(id);
    }catch (DataAccessException e){
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    if(nRiesgo == null){
      response.put("mensaje", "El Riesgo porcentaje con el Id: ".concat(id.toString().concat(" No Existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<NRiesgoPorcentaje>(nRiesgo, HttpStatus.OK);
  }
  
  @PostMapping("/riesgoporcentaje/new")
  public ResponseEntity<?> create(@RequestBody NRiesgoPorcentaje nRiesgo){
    NRiesgoPorcentaje nRiesgoNew = null;
    
    Map<String, Object> response  = new HashMap<>();
    
    try {
      nRiesgoNew = nRiesgoPorService.save(nRiesgo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El riesgo ha sido creado con éxito!");
    response.put("riesgo", nRiesgoNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/riesgoporcentaje/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Short id, @RequestBody NRiesgoPorcentaje nRiesgo){
    
    NRiesgoPorcentaje nRiesgoActual = nRiesgoPorService.findById(id);
    NRiesgoPorcentaje nRiesgoUpdated = null;
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if (nRiesgoActual == null) {
      response.put("mensaje", "error: no se puede editar, el riesgo con el ID: ".concat(id.toString().concat(" No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    try {
      nRiesgoActual.setCodigoriesgo(nRiesgo.getCodigoriesgo());
      nRiesgoActual.setNombreriesgo(nRiesgo.getNombreriesgo());
      nRiesgoActual.setPorcentajeriesgo(nRiesgo.getPorcentajeriesgo());
      
      nRiesgoUpdated = nRiesgoPorService.save(nRiesgoActual);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el riesgo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Riesgo con el ID: ".concat(nRiesgoUpdated.getCodigoriesgo().toString().concat(" ha sido actualizado con éxito!")));
    response.put("riesgo", nRiesgoUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("riesgoporcentaje/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Short id){
    Map<String, Object> response = new HashMap<>();
    NRiesgoPorcentaje nRiesgo = nRiesgoPorService.findById(id);
    try {
      if (nRiesgo == null) {
        response.put("error", "Error al Eliminar el riesgo con el ID: ".concat(id.toString().concat(" No Existe")));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }
      nRiesgoPorService.delete(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el riesgo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    response.put("mensaje", "El riesgo con el ID: ".concat(id.toString().concat(" ha sido eliminado con éxito!")));
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
  
}
