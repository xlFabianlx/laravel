package com.apirest.financiero.controllers;

import com.apirest.financiero.models.services.NCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.apirest.financiero.models.entity.NCargo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class NCargoController {

  @Autowired
  private NCargoService nCargoService;
  
  
  @GetMapping("/cargo/list")
  public List<NCargo> findAll (){
    return nCargoService.findAll();
  }
  
  @GetMapping("/cargo/{id}")
  public ResponseEntity<?> show(@PathVariable("id")Integer id){
    NCargo nCargo;
    
    Map<String, Object> response = new HashMap<>();
    
    try {
      nCargo = nCargoService.findById(id);
      if (nCargo == null) {
        response.put("mensaje", "El cargo con el ID:".concat(id.toString().concat(" no existe")));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return new ResponseEntity<>(nCargo, HttpStatus.OK);
  }

  @PostMapping("/cargo/new")
  public ResponseEntity<?> create(@RequestBody NCargo nCargo){

    Map<String, Object> response  = new HashMap <>();

    try {
      response.put("cargo", nCargoService.save(nCargo));
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "el cargo ha sido creado con éxito!");
    return new ResponseEntity <>(response, HttpStatus.CREATED);
  }


  @PutMapping("/cargo/update/")
  public ResponseEntity<?> update(@RequestBody NCargo nCargo) {

    NCargo ncargoActual = nCargoService.findById(nCargo.getId());

    Map<String, Object> response = new HashMap <>();
    if (ncargoActual != null) {
      try {
        response.put("cargo", nCargoService.save(nCargo));
      } catch ( DataAccessException e ) {
        response.put("mensaje", "El cargo con el ID: "+ nCargo.getId() + "No existe");
        response.put("erro", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      }

    }
    response.put("mensaje", "el cargo ha sido actualizado con éxito!");
    return new ResponseEntity <>(response, HttpStatus.ACCEPTED);
  }
}
