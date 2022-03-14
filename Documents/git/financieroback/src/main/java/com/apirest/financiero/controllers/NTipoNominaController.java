package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NTipoNomina;
import com.apirest.financiero.models.services.NTipoNominaService;
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
public class NTipoNominaController {

  @Autowired
  private NTipoNominaService nTipoNomService;
  
  
  @GetMapping("/tiponomina/list")
  public List<NTipoNomina> findAll(){
    return nTipoNomService.findAll();
  }
  
  @GetMapping("/tiponomina/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Short id){
    NTipoNomina nTipoNom = null;
    Map<String, Object> response = new HashMap<String, Object>();
    
    try{
      nTipoNom = nTipoNomService.findById(id);
    }catch (DataAccessException e){
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    if(nTipoNom == null){
      response.put("mensaje", "El Tipo nomina con el Id: ".concat(id.toString().concat(" No Existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<NTipoNomina>(nTipoNom, HttpStatus.OK);
  }
  
  @PostMapping("/tiponomina/new")
  public ResponseEntity<?> create(@RequestBody NTipoNomina nTipoNom){
    NTipoNomina nTipoNomNew = null;
    
    Map<String, Object> response  = new HashMap<>();
    
    try {
      nTipoNomNew = nTipoNomService.save(nTipoNom);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Tipo de nomina ha sido creado con éxito!");
    response.put("tipoNomina", nTipoNomNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/tiponomina/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Short id, @RequestBody NTipoNomina nTipoNom){
    
    NTipoNomina nTipoNomActual = nTipoNomService.findById(id);
    NTipoNomina nTipoNomUpdated = null;
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if (nTipoNomActual == null) {
      response.put("mensaje", "error: no se puede editar, el Tipo de nomina con el ID: ".concat(id.toString().concat(" No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    try {
      nTipoNomActual.setCodigoNomina(nTipoNom.getCodigoNomina());
      nTipoNomActual.setNombreNomina(nTipoNom.getNombreNomina());
     
      
      nTipoNomUpdated = nTipoNomService.save(nTipoNomActual);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el Tipo de nomina");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Riesgo con el ID: ".concat(nTipoNomUpdated.getCodigoNomina().toString().concat(" ha sido actualizado con éxito!")));
    response.put("riesgo", nTipoNomUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/tiponomina/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Short id){
    
    Map<String, Object> response = new HashMap<>();
    
    NTipoNomina nTipoNom = nTipoNomService.findById(id);
    
    try {
      if (nTipoNom == null) {
        response.put("error", "Error al Eliminar el tipo de nomina con el ID: ".concat(id.toString().concat(" No Existe")));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }
      nTipoNomService.delete(id);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el tipo de nomina");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    response.put("mensaje", "El tipo de nomina con el ID: ".concat(id.toString().concat(" ha sido eliminado con éxito!")));
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }

}
