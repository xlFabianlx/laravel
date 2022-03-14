package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CConpesHomol;
import com.apirest.financiero.models.services.CConpesHomolService;

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
public class CConpesHomolController {

    @Autowired
    private CConpesHomolService cConpesHomolService;

    @GetMapping("/cconpeshomol/list")
    public List<CConpesHomol> findAll() {
        return cConpesHomolService.findAll();
    }

    @GetMapping("/cconpeshomol/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Integer id) {
        CConpesHomol CConpesHomolActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CConpesHomolActual = cConpesHomolService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CConpesHomolActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CConpesHomol>(CConpesHomolActual, HttpStatus.OK);
    }

    @PostMapping("/cconpeshomol/new")
    public ResponseEntity<?> create(@RequestBody CConpesHomol cConpesHomol) {

        CConpesHomol CConpesHomolNew;
        Map<String, Object> response = new HashMap<>();

        try {
            CConpesHomolNew = cConpesHomolService.save(cConpesHomol);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("CConpesHomolNew", CConpesHomolNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cconpeshomol/updated")
    public ResponseEntity<?> update(@RequestBody CConpesHomol cConpesHomol) {
        CConpesHomol CConpesHomolActual = cConpesHomolService.findById(cConpesHomol.getConpHomoCod()); 
        CConpesHomol CConpesHomolUpdated;

        Map<String, Object> response = new HashMap<>();

        if (CConpesHomolActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            CConpesHomolUpdated = cConpesHomolService.save(cConpesHomol);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cConpes", CConpesHomolUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
