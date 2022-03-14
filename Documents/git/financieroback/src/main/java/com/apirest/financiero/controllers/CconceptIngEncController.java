package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CconceptIngEnc;
import com.apirest.financiero.models.services.CconceptIngEncService;

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
public class CconceptIngEncController {

    @Autowired
    private CconceptIngEncService cconceptIngEncService;

    @GetMapping("/concepto/ingresoenc/list")
    public List<CconceptIngEnc> findAll() {
        return cconceptIngEncService.findAll();
    }

    @GetMapping("/concepto/ingresoenc/list/pk")
    public ResponseEntity<?> show(@RequestBody CconceptIngEnc cconceptIngEnc) {
        CconceptIngEnc cconceptIngEncActual;
        Map<String, Object> response = new HashMap<>();

        try {
            cconceptIngEncActual = cconceptIngEncService.findByPK(cconceptIngEnc.getCconceptIngEncPK());
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cconceptIngEncActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CconceptIngEnc>(cconceptIngEncActual, HttpStatus.OK);
    }

    @PostMapping("/concepto/ingresoenc/list/new")
    public ResponseEntity<?> create(@RequestBody CconceptIngEnc cconceptIngEnc) {

        CconceptIngEnc cconceptIngEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cconceptIngEncNew = cconceptIngEncService.save(cconceptIngEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", cconceptIngEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/concepto/ingresoenc/list/updated")
    public ResponseEntity<?> update(@RequestBody CconceptIngEnc cconceptIngEnc) {
        CconceptIngEnc cconceptIngEncActual = cconceptIngEncService.findByPK(cconceptIngEnc.getCconceptIngEncPK());
        CconceptIngEnc cconceptIngEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cconceptIngEncActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cconceptIngEncUpdated = cconceptIngEncService.save(cconceptIngEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cconceptIngDet", cconceptIngEncUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
