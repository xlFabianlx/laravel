package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CconceptIngDet;
import com.apirest.financiero.models.services.CconceptIngDetService;

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
public class CconceptIngDetController {

    @Autowired
    private CconceptIngDetService cconceptIngDetService;

    @GetMapping("/concepto/ingresodet/list")
    public List<CconceptIngDet> findAll() {
        return cconceptIngDetService.findAll();
    }

    @GetMapping("/concepto/ingresodet/list/pk")
    public ResponseEntity<?> show(@RequestBody CconceptIngDet cconceptIngDet) {
        CconceptIngDet cconceptIngDetActual;
        Map<String, Object> response = new HashMap<>();

        try {
            cconceptIngDetActual = cconceptIngDetService.findByPK(cconceptIngDet.getCconceptIngDetPK());
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cconceptIngDetActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CconceptIngDet>(cconceptIngDetActual, HttpStatus.OK);
    }

    @PostMapping("/concepto/ingresodet/list/new")
    public ResponseEntity<?> create(@RequestBody CconceptIngDet cconceptIngDet) {

        CconceptIngDet cconceptIngDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cconceptIngDetNew = cconceptIngDetService.save(cconceptIngDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", cconceptIngDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/concepto/ingresodet/list/updated")
    public ResponseEntity<?> update(@RequestBody CconceptIngDet cconceptIngDet) {
        CconceptIngDet cconceptIngDetActual = cconceptIngDetService.findByPK(cconceptIngDet.getCconceptIngDetPK());
        CconceptIngDet cconceptIngDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cconceptIngDetActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cconceptIngDetUpdated = cconceptIngDetService.save(cconceptIngDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cconceptIngDet", cconceptIngDetUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
