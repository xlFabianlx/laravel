package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CAcuContablidad;
import com.apirest.financiero.models.entity.CAcuContablidadPK;
import com.apirest.financiero.models.services.CAcuContablidadService;

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
public class CAcuContablidadController {

    @Autowired
    private CAcuContablidadService cAcuContablidadService;

    @GetMapping("/cacu/contabilidad/list")
    public List<CAcuContablidad> findAll() {
        return cAcuContablidadService.findAll();
    }

    @GetMapping("/cacu/contabilidad/pk")
    public ResponseEntity<?> show(@RequestBody CAcuContablidadPK cAcuContablidadPK) {
        CAcuContablidad CAcuContablidadActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CAcuContablidadActual = cAcuContablidadService.findByPK(cAcuContablidadPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CAcuContablidadActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CAcuContablidad>(CAcuContablidadActual, HttpStatus.OK);
    }

    @PostMapping("/cacu/contabilidad/new")
    public ResponseEntity<?> create(@RequestBody CAcuContablidad cAcuContablidad) {

        CAcuContablidad cAcuContablidadNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cAcuContablidadNew = cAcuContablidadService.save(cAcuContablidad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cAcuContablidadNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cacu/contabilidad/updated")
    public ResponseEntity<?> update(@RequestBody CAcuContablidad cAcuContablidad) {
        CAcuContablidad cAcuContablidadActual = cAcuContablidadService.findByPK(cAcuContablidad.getCAcuContablidadPK()); 
        CAcuContablidad cAcuContablidadUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cAcuContablidadActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cAcuContablidadUpdated = cAcuContablidadService.save(cAcuContablidad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cAcuContablidadUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
