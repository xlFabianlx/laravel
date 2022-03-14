package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CPerContable;
import com.apirest.financiero.models.entity.CPerContablePK;
import com.apirest.financiero.models.services.CPerContableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CPerContableController {

    @Autowired
    private CPerContableService cPerContableService;

    @GetMapping("/cper/contable/list")
    public List<CPerContable> findAll() {
        return cPerContableService.findAll();
    }

    @GetMapping("/cper/contable/pk")
    public ResponseEntity<?> show(@RequestBody CPerContablePK CPerContablePK) {
        CPerContable CPerContableActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CPerContableActual = cPerContableService.findByPK(CPerContablePK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CPerContableActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CPerContable>(CPerContableActual, HttpStatus.OK);
    }

    @PostMapping("/cper/contable/new")
    public ResponseEntity<?> create(@RequestBody CPerContable cPerContable) {

        CPerContable cPerContableNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cPerContableNew = cPerContableService.save(cPerContable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cPerContableNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cper/contable/updated")
    public ResponseEntity<?> update(@RequestBody CPerContable cPerContable) {
        CPerContable cPerContableActual = cPerContableService.findByPK(cPerContable.getCPerContablePK()); 
        CPerContable cPerContableUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cPerContableActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cPerContableUpdated = cPerContableService.save(cPerContable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cPerContableUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
