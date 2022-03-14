package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PSolicitante;
import com.apirest.financiero.models.services.PSolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class PSolicitanteController {
    @Autowired
    private PSolicitanteService pSolicitanteService;

    @GetMapping("/solicitante/list")
    public List<PSolicitante> findAll() {
        return pSolicitanteService.findAll();
    }


    @GetMapping("/solicitante/{id}")
    public ResponseEntity<?> show(@PathVariable("id") String soliCod) {
        PSolicitante pSolicitante;
        Map<String, Object> response = new HashMap<>();

        try {
            pSolicitante = pSolicitanteService.findById(soliCod);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pSolicitante == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PSolicitante>(pSolicitante, HttpStatus.OK);
    }


    @PostMapping("/solicitante/new")
    public ResponseEntity<?> create(@RequestBody PSolicitante pSolicitante) {

        PSolicitante pSolicitanteNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pSolicitanteNew = pSolicitanteService.save(pSolicitante);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pSolicitanteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/solicitante/updated")
    public ResponseEntity<?> update(@RequestBody PSolicitante pSolicitante) {
        // PSolicitante pSolicitanteUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pSolicitante == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pSolicitante != null) {
                response.put("ordendepago", pSolicitanteService.save(pSolicitante));
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
