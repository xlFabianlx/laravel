package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NTipoLiquidacion;
import com.apirest.financiero.models.services.NTipoLiquidacionService;
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
public class NTipoLiquidacionController {

  @Autowired
  private NTipoLiquidacionService nTipoLiqService;
  
  
  @GetMapping("/tipoliquidacion/list")
  public List<NTipoLiquidacion> findAll(){
    return nTipoLiqService.findAll();
  }
  
  @GetMapping("/tipoliquidacion/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Short id){
    NTipoLiquidacion nTipoLiq = null;
    Map<String, Object> response = new HashMap<String, Object>();
    
    try{
      nTipoLiq = nTipoLiqService.findById(id);
    }catch (DataAccessException e){
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    if(nTipoLiq == null){
      response.put("mensaje", "El Tipo liquidacion con el Id: ".concat(id.toString().concat(" No Existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<NTipoLiquidacion>(nTipoLiq, HttpStatus.OK);
  }
  
  @PostMapping("/tipoliquidacion/new")
  public ResponseEntity<?> create(@RequestBody NTipoLiquidacion nTipoLiq){
    NTipoLiquidacion nTipoLiqNew = null;
    
    Map<String, Object> response  = new HashMap<>();
    
    try {
      nTipoLiqNew = nTipoLiqService.save(nTipoLiq);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Tipo de liquidacion ha sido creado con éxito!");
    response.put("riesgo", nTipoLiqNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/tipoliquidacion/{id}")
  public ResponseEntity<?> update(@PathVariable("id") Short id, @RequestBody NTipoLiquidacion nTipoLiq){
    
    NTipoLiquidacion nTipoLiqActual = nTipoLiqService.findById(id);
    NTipoLiquidacion nTipoLiqUpdated = null;
    
    Map<String, Object> response = new HashMap<String, Object>();
    
    if (nTipoLiqActual == null) {
      response.put("mensaje", "error: no se puede editar, el Tipo de liquidacion con el ID: ".concat(id.toString().concat(" No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    
    try {
      nTipoLiqActual.setCodigoTipoL(nTipoLiq.getCodigoTipoL());
      nTipoLiqActual.setNombreTipoL(nTipoLiq.getNombreTipoL());
      nTipoLiqActual.setAbreviatura(nTipoLiq.getAbreviatura());
      
      nTipoLiqUpdated = nTipoLiqService.save(nTipoLiqActual);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al actualizar el Tipo de liquidacion");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    response.put("mensaje", "El Riesgo con el ID: ".concat(nTipoLiqUpdated.getCodigoTipoL().toString().concat(" ha sido actualizado con éxito!")));
    response.put("riesgo", nTipoLiqUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("tipoliquidacion/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Short id){
    
    Map<String, Object> response = new HashMap<>();
    
    NTipoLiquidacion nTipoLiq = nTipoLiqService.findById(id);
    
    try {
      if (nTipoLiq == null) {
        response.put("error", "Error al Eliminar el tipo de liquidacion con el ID: ".concat(id.toString().concat(" No Existe")));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
      }
      nTipoLiqService.delete(id);
      
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el tipo de liquidacion");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      
    }
    
    response.put("mensaje", "El tipo de liquidacion con el ID: ".concat(id.toString().concat(" ha sido eliminado con éxito!")));
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
  
}
