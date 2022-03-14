package com.apirest.financiero.controllers;

  import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.financiero.models.entity.NConceptoGrupo;
import com.apirest.financiero.models.entity.NConceptoGrupoPK;
import com.apirest.financiero.models.services.NConceptoGrupoService;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1")
public class NConceptoGrupoController {

  @Autowired
  private NConceptoGrupoService nConceptoGrupoService;

  @GetMapping("/conceptogrupo/list")
  public List<NConceptoGrupo> listAll() {
    return nConceptoGrupoService.findAll();
  }

  @GetMapping("/conceptogrupo/{idCodigo}/{idConcepto}")
  public ResponseEntity<?> show(@PathVariable("idCodigo") Integer idCodigo, @PathVariable("idConcepto") String idConcepto,
    NConceptoGrupoPK nConceptoGrupoPK){
    nConceptoGrupoPK.setCodigoGrupo(idCodigo);
    nConceptoGrupoPK.setCodigoConcepto(idConcepto);
    NConceptoGrupo nConceptoGrupo;

    Map<String, Object> response = new HashMap<>();

    try {
      nConceptoGrupo = nConceptoGrupoService.findById(nConceptoGrupoPK);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (nConceptoGrupo == null) {
      response.put("mensaje", "El Concepto Grupo con el ID:".concat(nConceptoGrupoPK.toString().concat(" no existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(nConceptoGrupo, HttpStatus.OK);
  }

  @PostMapping("/conceptogrupo/new")
  public ResponseEntity<?> create(@Valid @RequestBody NConceptoGrupo nConceptoGrupo, BindingResult result) {

    NConceptoGrupo nConceptoGrupoNew;
    Map<String, Object> response = new HashMap<>();

    if (result.hasErrors()) {

      List<String> errors = result.getFieldErrors()
          .stream()
          .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
          .collect(Collectors.toList());

      response.put("errors", errors);
      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    try {
      nConceptoGrupoNew = nConceptoGrupoService.save(nConceptoGrupo);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El concepto grupo ha sido creado con éxito!");
    response.put("cliente", nConceptoGrupoNew);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PutMapping("/conceptogrupo/update/{idCodigo}/{idConcepto}")
  public ResponseEntity<?> update(@RequestBody NConceptoGrupo nConceptoGrupo,
      NConceptoGrupoPK nConceptoGrupoPk, @PathVariable("idCodigo") Integer idCodigo,
      @PathVariable("idConcepto") String idConcepto) {
    nConceptoGrupoPk.setCodigoGrupo(idCodigo);
    nConceptoGrupoPk.setCodigoConcepto(idConcepto);
    System.out.println(nConceptoGrupoPk);
    NConceptoGrupo nConceptoGrupoActual = nConceptoGrupoService.findById(nConceptoGrupoPk);
    NConceptoGrupo nConceptoGrupoUpdated;

    Map<String, Object> response = new HashMap<>();

    if (nConceptoGrupoActual == null) {
      response.put("mensaje", "Eror: no se puede editar, el el concepto grupo con el ID: ".concat(nConceptoGrupoPk.toString().concat(". No existe")));
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    try {
      nConceptoGrupoActual.setCuentaGasto(nConceptoGrupo.getCuentaGasto());
      nConceptoGrupoActual.setCuentaPresupuesto(nConceptoGrupo.getCuentaPresupuesto());
      nConceptoGrupoActual.setCuentaPagar(nConceptoGrupo.getCuentaPagar());

      nConceptoGrupoUpdated = nConceptoGrupoService.save(nConceptoGrupoActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el grupo concepto");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El Concepto grupo ha sido actualizado con éxito!");
    response.put("cliente", nConceptoGrupoUpdated);

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @DeleteMapping("/conceptogrupo/delete/{idCodigo}/{idConcepto}")
  public ResponseEntity<?> deleteEntidad(@PathVariable("idCodigo") Integer idCodigo, @PathVariable("idConcepto") String idConcepto, NConceptoGrupoPK nConceptoGrupoPk) {
    nConceptoGrupoPk.setCodigoGrupo(idCodigo);
    nConceptoGrupoPk.setCodigoConcepto(idConcepto);
    Map<String, Object> response = new HashMap<>();

    try {
      nConceptoGrupoService.deleteById(nConceptoGrupoPk);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el grupo concepto");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El Concepto Grupo con id " + nConceptoGrupoPk.getCodigoGrupo() + " ha sido eliminado con éxito!");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
