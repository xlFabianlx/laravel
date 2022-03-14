package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PRendicion;
import com.apirest.financiero.models.services.PRendicionService;
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
public class PRendicionController {
    @Autowired
    private PRendicionService pRendicionService;

    @GetMapping("/rendicion/list")
    public List<PRendicion> findAll() {
        return pRendicionService.findAll();
    }


    @GetMapping("/rendicion/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Short perRendCod) {
        PRendicion pRendicion;
        Map<String, Object> response = new HashMap<>();

        try {
            pRendicion = pRendicionService.findById(perRendCod);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pRendicion == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PRendicion>(pRendicion, HttpStatus.OK);
    }


    @PostMapping("/rendicion/new")
    public ResponseEntity<?> create(@RequestBody PRendicion pRendicion) {

        PRendicion pRendicionNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pRendicionNew = pRendicionService.save(pRendicion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pRendicionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/rendicion/updated")
    public ResponseEntity<?> update(@RequestBody PRendicion pRendicion) {
        // PRendicion pRendicionUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pRendicion == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pRendicion != null) {
                response.put("ordendepago", pRendicionService.save(pRendicion));
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
