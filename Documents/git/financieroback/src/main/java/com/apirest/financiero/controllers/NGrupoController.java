package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NGrupo;
import com.apirest.financiero.models.services.NGrupoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
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

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1")
public class NGrupoController {

  @Autowired
  private NGrupoService nGrupoService;

  @GetMapping("/grupo/list")
  public List<NGrupo> findAll() {
    return nGrupoService.findAll();
  }

  @GetMapping("/grupo/byId/{id}")
  public ResponseEntity<?> show(@PathVariable("id") String id) {
    NGrupo nGrupo;

    Map<String, Object> response = new HashMap<>();

    try {
      nGrupo = nGrupoService.findById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Realizar la consulta");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (nGrupo == null) {
      response.put("mensaje", "El fondo con el ID:".concat(id.concat(" no existe")));
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(nGrupo, HttpStatus.OK);
  }

  @PostMapping("/grupo/new")
  public ResponseEntity<?> create(@RequestBody NGrupo nGrupo) {
    NGrupo nGrupoNew;
    Map<String, Object> response = new HashMap<>();

    try {
      nGrupoNew = nGrupoService.save(nGrupo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El grupo con el ID: " + nGrupoNew.getCodigoGrupo() + " ha sido creado con éxito!");
    response.put("Fondo", nGrupoNew);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PutMapping("/grupo/update/{id}")
  public ResponseEntity<?> update(@Valid @RequestBody NGrupo nGrupo, @PathVariable String id) {

    NGrupo grupoActual = nGrupoService.findById(id);
    NGrupo grupoActualizado;

    Map<String, Object> response = new HashMap<>();

    if (grupoActual == null) {
      response.put("mensaje", "Error: no se puede editar, el grupo con el ID: ".concat(id.concat(". No existe")));
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    try {
      grupoActual.setCodigoGrupo(nGrupo.getCodigoGrupo());
      grupoActual.setNombreGrupo(nGrupo.getNombreGrupo());
      grupoActualizado = nGrupoService.save(grupoActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el grupo");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El grupo con el ID: " + nGrupo.getCodigoGrupo() + " ha sido actualizado con éxito!");
    response.put("grupo", grupoActualizado);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/grupo/delete/{id}")
  public ResponseEntity<?> deleteEntidad(@PathVariable("id") String id) {

    Map<String, Object> response = new HashMap<>();

    try {
      nGrupoService.deleteById(id);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el grupo");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El grupo con ID: " + id + " ha sido eliminado con éxito!");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
