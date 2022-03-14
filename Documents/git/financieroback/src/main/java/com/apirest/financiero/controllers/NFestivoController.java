package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NFestivo;
import com.apirest.financiero.models.services.NFestivoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1")
public class NFestivoController {

  @Autowired
  private NFestivoService nFestivoService;

  @GetMapping("/festivo/list")
  public List<NFestivo> findAll() {
    return nFestivoService.findAll();
  }

  @GetMapping("/festivo/{id}")
  public ResponseEntity<?> show(@PathVariable("id") Integer idFestivo) {
    NFestivo nFestivo = null;

    Map<String, Object> response = new HashMap<>();

    try {
      nFestivo = nFestivoService.findById(idFestivo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Realizar la consulta");
      response.put("error", e.getMessage().concat(": ")
          .concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (nFestivo == null) {
      response.put("mensaje", "El festivo con el ID:".concat(idFestivo.toString().concat(" no existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<NFestivo>(nFestivo, HttpStatus.OK);
  }

  @PostMapping("/festivo/new")
  public ResponseEntity<?> create(@RequestBody NFestivo nFestivo) {
    NFestivo nFestivoNew = null;
    Map<String, Object> response = new HashMap<>();

    try {
      nFestivoNew = nFestivoService.save(nFestivo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El festivo con el ID: " + nFestivoNew.getIdFestivo() + " ha sido creado con éxito!");
    response.put("festivo", nFestivoNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @PutMapping("/festivo/update/{idFestivo}")
  public ResponseEntity<?> update(@Valid @RequestBody NFestivo nFestivo, BindingResult result, @PathVariable Integer idFestivo) {

    NFestivo festivoActual = nFestivoService.findById(idFestivo);
    NFestivo festivoActualizado = null;

    Map<String, Object> response = new HashMap<>();

    if (result.hasErrors()) {

      List<String> errors = result.getFieldErrors()
          .stream()
          .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
          .collect(Collectors.toList());

      response.put("errors", errors);
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    if (festivoActual == null) {
      response.put("mensaje", "Eror: no se puede editar, el festivo con el ID: ".concat(idFestivo.toString().concat(". No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {

      festivoActual.setFecha(nFestivo.getFecha());
      festivoActual.setUsuario(nFestivo.getUsuario());

      festivoActualizado = nFestivoService.save(festivoActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el festivo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El festivo con el ID: " + nFestivo.getIdFestivo() + " ha sido actualizado con éxito!");
    response.put("festivo", festivoActualizado);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/festivo/delete/{idFestivo}")
  public ResponseEntity<?> deleteEntidad(@PathVariable("idFestivo") Integer idFestivo) {

    Map<String, Object> response = new HashMap<>();

    try {
      nFestivoService.deleteById(idFestivo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el Festivo");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El Festivo con ID: " + idFestivo + " ha sido eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }

}
