package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CConpes;
import com.apirest.financiero.models.services.CConpesService;

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
public class CConpesController {

    @Autowired
    private CConpesService cConpesService;

    @GetMapping("/cconpes/list")
    public List<CConpes> findAll() {
        return cConpesService.findAll();
    }

    @GetMapping("/cconpes/pk")
    public ResponseEntity<?> show(@RequestBody CConpes cConpes) {
        CConpes CConpesActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CConpesActual = cConpesService.findByPK(cConpes.getCConpesPK());
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CConpesActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CConpes>(CConpesActual, HttpStatus.OK);
    }

    @PostMapping("/cconpes/new")
    public ResponseEntity<?> create(@RequestBody CConpes cConpes) {

        CConpes cConpesNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cConpesNew = cConpesService.save(cConpes);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("cConpesNew", cConpesNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cconpes/updated")
    public ResponseEntity<?> update(@RequestBody CConpes cConpes) {
        CConpes cConpesActual = cConpesService.findByPK(cConpes.getCConpesPK()); 
        CConpes cConpesUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cConpesActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cConpesUpdated = cConpesService.save(cConpes);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cConpes", cConpesUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
