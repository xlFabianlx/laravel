package com.apirest.financiero.controllers;

import com.apirest.financiero.models.services.NFondoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.financiero.models.entity.NFondo;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1")
public class NFondoController {

  @Autowired
  private NFondoService nFondoService;

  @GetMapping("/fondo/list")
  public List<NFondo> findAll() {
    return nFondoService.findAll();
  }

  @GetMapping("/fondo/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Short codigoEntidad) {
    NFondo nFondo = null;

    Map<String, Object> response = new HashMap<>();

    try {
      nFondo = nFondoService.findById(codigoEntidad);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Realizar la consulta");
      response.put("error", e.getMessage().concat(": ")
          .concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (nFondo == null) {
      response.put("mensaje", "El fondo con el ID:".concat(codigoEntidad.toString().concat(" no existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<NFondo>(nFondo, HttpStatus.OK);
  }

  @PostMapping("/fondo/new")
  public ResponseEntity<?> create(@RequestBody NFondo nFondo) {
    NFondo nFondoNew = null;
    Map<String, Object> response = new HashMap<>();

    try {
      nFondoNew = nFondoService.save(nFondo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El Fondo con el ID: " + nFondoNew.getCodigoEntidad() + " ha sido creado con éxito!");
    response.put("Fondo", nFondoNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @PutMapping("/fondo/update/{codigoEntidad}")
  public ResponseEntity<?> update(@Valid @RequestBody NFondo nFondo, BindingResult result, @PathVariable Short codigoEntidad) {

    NFondo fondoActual = nFondoService.findById(codigoEntidad);
    NFondo fondoActualizado = null;

    Map<String, Object> response = new HashMap<>();

    if (fondoActual == null) {
      response.put("mensaje", "Eror: no se puede editar, el fondo con el ID: ".concat(codigoEntidad.toString().concat(". No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {

      fondoActual.setCodigoEntidad(nFondo.getCodigoEntidad());
      fondoActual.setNombreEntidad(nFondo.getNombreEntidad());
      fondoActual.setCajacC(nFondo.isCajacC());
      fondoActual.setEps(nFondo.isEps());
      fondoActual.setPension(nFondo.isPension());
      fondoActual.setCesantia(nFondo.isCesantia());
      fondoActual.setArl(nFondo.isArl());
      fondoActual.setNit(nFondo.getNit());
      fondoActual.setCodigoCta(nFondo.getCodigoCta());
      fondoActual.setRubo(nFondo.getRubo());
      fondoActual.setRegistro(nFondo.getRegistro());

      fondoActualizado = nFondoService.save(fondoActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el festivo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El fondo con el ID: " + nFondo.getCodigoEntidad() + " ha sido actualizado con éxito!");
    response.put("fondo", fondoActualizado);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/fondo/delete/{codigoEntidad}")
  public ResponseEntity<?> deleteEntidad(@PathVariable("codigoEntidad") Short codigoEntidad) {

    Map<String, Object> response = new HashMap<>();

    try {
      nFondoService.deleteById(codigoEntidad);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el Festivo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El Fondo con ID: " + codigoEntidad + " ha sido eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
