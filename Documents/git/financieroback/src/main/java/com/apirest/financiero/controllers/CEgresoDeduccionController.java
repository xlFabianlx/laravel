package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CEgresoDeduccion;
import com.apirest.financiero.models.entity.CEgresoDeduccionPK;
import com.apirest.financiero.models.services.CEgresoDeduccionService;

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
public class CEgresoDeduccionController {

    @Autowired
    private CEgresoDeduccionService cEgresoDeduccionService;

    @GetMapping("/cegreso/deduccion/list")
    public List<CEgresoDeduccion> findAll() {
        return cEgresoDeduccionService.findAll();
    }

    @GetMapping("/cegreso/deduccion/pk")
    public ResponseEntity<?> show(@RequestBody CEgresoDeduccionPK CEgresoDeduccionPK) {
        CEgresoDeduccion CEgresoDeduccionActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CEgresoDeduccionActual = cEgresoDeduccionService.findByPK(CEgresoDeduccionPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CEgresoDeduccionActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CEgresoDeduccion>(CEgresoDeduccionActual, HttpStatus.OK);
    }

    @PostMapping("/cegreso/deduccion/new")
    public ResponseEntity<?> create(@RequestBody CEgresoDeduccion CEgresoDeduccion) {

        CEgresoDeduccion CEgresoDeduccionNew;
        Map<String, Object> response = new HashMap<>();

        try {
            CEgresoDeduccionNew = cEgresoDeduccionService.save(CEgresoDeduccion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", CEgresoDeduccionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cegreso/deduccion/updated")
    public ResponseEntity<?> update(@RequestBody CEgresoDeduccion CEgresoDeduccion) {
        CEgresoDeduccion CEgresoDeduccionActual = cEgresoDeduccionService.findByPK(CEgresoDeduccion.getCEgresoDeduccionPK()); 
        CEgresoDeduccion CEgresoDeduccionUpdated;

        Map<String, Object> response = new HashMap<>();

        if (CEgresoDeduccionActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            CEgresoDeduccionUpdated = cEgresoDeduccionService.save(CEgresoDeduccion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", CEgresoDeduccionUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
