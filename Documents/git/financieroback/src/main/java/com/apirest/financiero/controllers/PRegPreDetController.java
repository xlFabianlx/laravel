package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PRegPreDet;
import com.apirest.financiero.models.entity.PRegPreDetPK;
import com.apirest.financiero.models.services.PRegPreDetService;
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
public class PRegPreDetController {
    @Autowired
    private PRegPreDetService pRegPreDetService;

    @GetMapping("/regpredet/list")
    public List<PRegPreDet> findAll() {
        return pRegPreDetService.findAll();
    }


    @GetMapping("/regpredet/pk")
    public ResponseEntity<?> show(@RequestBody PRegPreDetPK pRegPreDetPK) {
        PRegPreDet pRegPreDet;
        Map<String, Object> response = new HashMap<>();

        try {
            pRegPreDet = pRegPreDetService.findById(pRegPreDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pRegPreDet == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PRegPreDet>(pRegPreDet, HttpStatus.OK);
    }


    @PostMapping("/regpredet/new")
    public ResponseEntity<?> create(@RequestBody PRegPreDet pRegPreDet) {

        PRegPreDet pRegPreDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pRegPreDetNew = pRegPreDetService.save(pRegPreDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pRegPreDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/regpredet/updated")
    public ResponseEntity<?> update(@RequestBody PRegPreDet pRegPreDet) {
        // PRegPreDet pRegPreDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pRegPreDet == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pRegPreDet != null) {
                response.put("ordendepago", pRegPreDetService.save(pRegPreDet));
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
