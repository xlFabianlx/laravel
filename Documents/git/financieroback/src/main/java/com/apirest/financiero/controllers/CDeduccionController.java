package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CDeduccion;
import com.apirest.financiero.models.services.CDeduccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CDeduccionController {

    @Autowired
    private CDeduccionService cDeduccionService;

    @GetMapping("/cdeduccion/list")
    public List<CDeduccion> findAll() {
        return cDeduccionService.findAll();
    }

   @GetMapping("/cdeduccion/codigo/{dedCod}")
    public CDeduccion findByDedCod(@PathVariable("dedCod") Short dedCod) {
        return cDeduccionService.findByDedCod(dedCod);
    }

     @GetMapping("/cdeduccion/terCod/{terCod}")
    public List<Map<String, ?>> getDeduccionesTercerosActivos(@PathVariable("terCod") Long terCod) {
        return cDeduccionService.getDeduccionesTercerosActivos(terCod);
    }  

    @GetMapping("/cdeduccion/id")
    public ResponseEntity<?> show(@PathVariable("id") Short id) {
        CDeduccion CDeduccionActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CDeduccionActual = cDeduccionService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CDeduccionActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CDeduccion>(CDeduccionActual, HttpStatus.OK);
    }

    @PostMapping("/cdeduccion/new")
    public ResponseEntity<?> create(@RequestBody CDeduccion cDeduccion) {

        CDeduccion cDeduccionNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cDeduccionNew = cDeduccionService.save(cDeduccion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cDeduccionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cdeduccion/updated")
    public ResponseEntity<?> update(@RequestBody  CDeduccion cDeduccion) {
        CDeduccion cDeduccionActual = cDeduccionService.findById(cDeduccion.getDedCod()); 
        CDeduccion cDeduccionUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cDeduccionActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cDeduccionUpdated = cDeduccionService.save(cDeduccion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cDeduccionUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
