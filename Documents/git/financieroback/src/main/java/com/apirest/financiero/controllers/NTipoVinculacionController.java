package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NTipoVinculacion;
import com.apirest.financiero.models.services.NTipoVinculacionService;
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
public class NTipoVinculacionController {

  @Autowired
  private NTipoVinculacionService nTipoVincService;
  
  @GetMapping("/tipovinculacion/list")
  public List<NTipoVinculacion> findAll(){
    return nTipoVincService.findAll();
  }
  
  @GetMapping("/tipovinculacion/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Integer id){
    NTipoVinculacion nTipoVinc = null;
    Map<String, Object> response = new HashMap<String, Object>();
    
    try{
      nTipoVinc = nTipoVincService.findById(id);
    }catch (DataAccessException e){
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    if(nTipoVinc == null){
      response.put("mensaje", "El Tipo de vinculacion con el Id: ".concat(id.toString().concat(" No Existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<NTipoVinculacion>(nTipoVinc, HttpStatus.OK);
  }
  
  @PostMapping("/tipovinculacion/new")
  public ResponseEntity<?> create(@RequestBody NTipoVinculacion nTipoVinc){
    NTipoVinculacion nTipoVincNew = null;
    
    Map<String, Object> response  = new HashMap<>();
    
    try {
      nTipoVincNew = nTipoVincService.save(nTipoVinc);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Tipo de vinculacion ha sido creado con éxito!");
    response.put("tipoNomina", nTipoVincNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/tipovinculacion/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody NTipoVinculacion nTipoVinc){
    
    NTipoVinculacion nTipoVincActual = nTipoVincService.findById(id);
    NTipoVinculacion nTipoVincUpdated = null;
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if (nTipoVincActual == null) {
      response.put("mensaje", "error: no se puede editar, el Tipo de vinculacion con el ID: ".concat(id.toString().concat(" No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    try {
      nTipoVincActual.setCodigoVin(nTipoVinc.getCodigoVin());
      nTipoVincActual.setNombreVin(nTipoVinc.getNombreVin());
      nTipoVincActual.setCodigoEst(nTipoVinc.getCodigoEst());
      
      nTipoVincUpdated = nTipoVincService.save(nTipoVincActual);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el Tipo de vinculacion");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El tipo de vinculacion con el ID: ".concat(nTipoVincUpdated.getCodigoVin().toString().concat(" ha sido actualizado con éxito!")));
    response.put("riesgo", nTipoVincUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/tipovinculacion/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer id){
    
    Map<String, Object> response = new HashMap<>();
    
    NTipoVinculacion nTipoNomVinc = nTipoVincService.findById(id);
    
    try {
      if (nTipoNomVinc == null) {
        response.put("error", "Error al Eliminar el tipo de vinculacion con el ID: ".concat(id.toString().concat(" No Existe")));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }
      nTipoVincService.delete(id);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el tipo de vinculacion");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    response.put("mensaje", "El tipo de vinculacion con el ID: ".concat(id.toString().concat(" ha sido eliminado con éxito!")));
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }

}
