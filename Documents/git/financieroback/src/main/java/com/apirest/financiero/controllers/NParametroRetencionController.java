package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.NParametroRetencion;
import com.apirest.financiero.models.services.NParametroRetencionService;

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
public class NParametroRetencionController {
  
  @Autowired
  private NParametroRetencionService nParametroRetencionService;
  
  @GetMapping("/paramretencion/list")
  public List<NParametroRetencion> findAll(){
    return nParametroRetencionService.findAll();
  }
  
  @GetMapping("/paramretencion/find/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Integer id) {
    NParametroRetencion nParametroRetencion = null;
    Map<String, Object> response = new HashMap<>();

    try {
      nParametroRetencion = nParametroRetencionService.findById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (nParametroRetencion == null) {
      response.put("mensaje", "El parametro de la retencion con el ID: ".concat(id.toString().concat(" no existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<NParametroRetencion>(nParametroRetencion, HttpStatus.OK);
  }
  
  @PostMapping("/paramretencion/new")
  public ResponseEntity<?> create(@RequestBody NParametroRetencion nParametroRetencion) {

    NParametroRetencion nParametroRetencionNew = null;
    Map<String, Object> response = new HashMap<>();

    try {
      nParametroRetencionNew = nParametroRetencionService.save(nParametroRetencion);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El Parametro con el ID: "+nParametroRetencionNew.getRegistro()+" ha sido creado con éxito!");
    response.put("ParametroRetencion", nParametroRetencionNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @PutMapping("/paramretencion/update/{id}")
  public ResponseEntity<?> update(@RequestBody NParametroRetencion nParametroRetencion, @PathVariable Integer id) {

    NParametroRetencion nParametroRetencionActual = nParametroRetencionService.findById(id);
    NParametroRetencion nParametroRetencionUpdated = null;

    Map<String, Object> response = new HashMap<>();


    if (nParametroRetencionActual == null) {
      response.put("mensaje", "Eror: no se puede editar, el parametro con el ID: ".concat(id.toString().concat(". No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {

      nParametroRetencionActual.setValorInferior(nParametroRetencion.getValorInferior());
      nParametroRetencionActual.setValorSuperior(nParametroRetencion.getValorSuperior());
      nParametroRetencionActual.setPorcentaje(nParametroRetencion.getPorcentaje());
      nParametroRetencionActual.setValoraRetener(nParametroRetencion.getValoraRetener());

      nParametroRetencionUpdated = nParametroRetencionService.save(nParametroRetencionActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el parametro");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El Parámetro "+nParametroRetencionUpdated.getRegistro()+ " ha sido actualizado con éxito!");
    response.put("parametro", nParametroRetencionUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/paramretencion/delete/{id}")
  public ResponseEntity<?> delete(@PathVariable Integer id) {

    Map<String, Object> response = new HashMap<>();

    try {
      nParametroRetencionService.deleteById(id);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al Eliminar el parametro");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El parametro con el ID: "+ id +" ha sido eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

  }
}
