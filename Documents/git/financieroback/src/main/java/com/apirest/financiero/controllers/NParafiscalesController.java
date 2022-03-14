package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.NParafiscales;
import com.apirest.financiero.models.entity.NParafiscalesPK;
import com.apirest.financiero.models.services.NParafiscalService;

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
public class NParafiscalesController {

  @Autowired
  private NParafiscalService nParafiscalService;

  @GetMapping("/parafiscales/list")
  public List<NParafiscales> findAll() {
    return nParafiscalService.findAll();
  }

  @GetMapping("/parafiscales/find/{codigoParafiscal}/{codigoEntidad}")
  public ResponseEntity<?> show(
    @PathVariable("codigoParafiscal") int codigoParafiscal,
    @PathVariable("codigoEntidad") int codigoEntidad,
    NParafiscalesPK nParafiscalesPK) {
    nParafiscalesPK.setCodigoParafiscal(codigoParafiscal);
    nParafiscalesPK.setCodigoEntidad(codigoEntidad);

    NParafiscales nParafiscales = null;

    Map<String, Object> response = new HashMap<>();
    try {
      nParafiscales = nParafiscalService.findById(nParafiscalesPK);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage().concat(": ")
          .concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    if (nParafiscales == null) {
      response.put("mensaje", "El registro Parafiscal con el ID:".concat(nParafiscalesPK.toString().concat(" no existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<NParafiscales>(nParafiscales, HttpStatus.OK);
  }

  @PostMapping("/parafiscal/new")
  public ResponseEntity<?> create(@RequestBody NParafiscales nParafiscales) {

    NParafiscales nParafiscalesNew = null;
    Map<String, Object> response = new HashMap<>();

    try {
      nParafiscalesNew = nParafiscalService.save(nParafiscales);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la inserción");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    response.put("mensaje", "El Parafiscal " + nParafiscalesNew.getNombreParafiscal() + "  ha sido creado con éxito!");
    response.put("Parafiscal", nParafiscalesNew);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }

  @PutMapping("/parafiscal/update/{codigoParafiscal}/{codigoEntidad}")
  public ResponseEntity<?> update(@RequestBody NParafiscales nParafiscales,
    @PathVariable("codigoParafiscal") int codigoParafiscal,
    @PathVariable("codigoEntidad") int codigoEntidad,
    NParafiscalesPK nParafiscalesPK
    ) {
    nParafiscalesPK.setCodigoParafiscal(codigoParafiscal);
    nParafiscalesPK.setCodigoEntidad(codigoEntidad);
    NParafiscales nParafiscalActual = nParafiscalService.findById(nParafiscalesPK);
    NParafiscales nParafiscalUpdated = null;

    Map<String, Object> response = new HashMap<>();

    if (nParafiscalActual == null) {
      response.put("mensaje", "Eror: no se puede editar, el parafiscal con el ID: ".concat(nParafiscalesPK.toString().concat(". No existe")));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {
      nParafiscalActual.setNombreParafiscal(nParafiscales.getNombreParafiscal());
      nParafiscalActual.setAbreviatura(nParafiscales.getAbreviatura());
      nParafiscalActual.setPorcentajeParafiscal(nParafiscales.getPorcentajeParafiscal());

      nParafiscalUpdated = nParafiscalService.save(nParafiscalActual);

    } catch (DataAccessException e) {

      response.put("mensaje", "Error al actualizar el parafiscal concepto");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    response.put("mensaje", "El ParaFiscal ha sido actualizado con éxito!");
    response.put("parafiscal", nParafiscalUpdated);

    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
  }
  
  @DeleteMapping("/parafiscal/delete/{codigoParafiscal}/{codigoEntidad}")
  public ResponseEntity<?> deleteEntidad(
    @PathVariable("codigoParafiscal") int codigoParafiscal,
    @PathVariable("codigoEntidad") int codigoEntidad,
      NParafiscalesPK nParafiscalesPK)
  {
    nParafiscalesPK.setCodigoParafiscal(codigoParafiscal);
    nParafiscalesPK.setCodigoEntidad(codigoEntidad);
    Map<String, Object> response = new HashMap<>();

    try {
      nParafiscalService.deleteById(nParafiscalesPK);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al Eliminar el parafiscal concepto");
      response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El parafiscal con el id " + nParafiscalesPK.getCodigoParafiscal() + " ha sido eliminado con éxito!");
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
  }
}
