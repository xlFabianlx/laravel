package com.apirest.financiero.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// IMPORTS
import com.apirest.financiero.models.entity.PTFuente;
import com.apirest.financiero.models.services.PTFuenteService;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")

public class PTFuenteController {

    @Autowired
    private PTFuenteService Service;

    @GetMapping("/fuente/list")
    public List<PTFuente> findAll() {
        return Service.findAll();
    }

    @GetMapping("/fuente/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Short id) {
        PTFuente modelo;
        Map<String, Object> response = new HashMap<>();

        try {
            modelo = Service.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (modelo == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PTFuente>(modelo, HttpStatus.OK);
    }


    @PostMapping("/fuente/new")
    public ResponseEntity<?> create(@RequestBody PTFuente modelo) {

        PTFuente nuevoModelo;
        Map<String, Object> response = new HashMap<>();

        try {
            nuevoModelo = Service.save(modelo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", nuevoModelo);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/fuente/updated")
    public ResponseEntity<?> update(@RequestBody PTFuente modelo) {

        Map<String, Object> response = new HashMap<>();

        if (modelo == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(modelo != null) {
                response.put("ordendepago", Service.save(modelo));
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
