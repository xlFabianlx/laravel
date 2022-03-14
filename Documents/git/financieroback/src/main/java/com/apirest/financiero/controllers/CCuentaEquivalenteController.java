package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CCuentaEquivalente;
import com.apirest.financiero.models.entity.CCuentaEquivalentePK;
import com.apirest.financiero.models.services.CCuentaEquivalenteService;

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
public class CCuentaEquivalenteController {

    @Autowired
    private CCuentaEquivalenteService cCuentaEquivalenteService;

    @GetMapping("/ccuentaequivalente/list")
    public List<CCuentaEquivalente> findAll() {
        return cCuentaEquivalenteService.findAll();
    }

    @GetMapping("/ccuentaequivalente/pk")
    public ResponseEntity<?> show(@RequestBody CCuentaEquivalentePK CCuentaEquivalentePK) {
        CCuentaEquivalente CCuentaEquivalenteActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CCuentaEquivalenteActual = cCuentaEquivalenteService.findByPK(CCuentaEquivalentePK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CCuentaEquivalenteActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CCuentaEquivalente>(CCuentaEquivalenteActual, HttpStatus.OK);
    }

    @PostMapping("/ccuentaequivalente/new")
    public ResponseEntity<?> create(@RequestBody CCuentaEquivalente cCuentaEquivalente) {

        CCuentaEquivalente CCuentaEquivalenteNew;
        Map<String, Object> response = new HashMap<>();

        try {
            CCuentaEquivalenteNew = cCuentaEquivalenteService.save(cCuentaEquivalente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("cConpesNew", CCuentaEquivalenteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/ccuentaequivalente/updated")
    public ResponseEntity<?> update(@RequestBody CCuentaEquivalente cCuentaEquivalente) {
        CCuentaEquivalente cCuentaEquivalenteActual = cCuentaEquivalenteService.findByPK(cCuentaEquivalente.getCCuentaEquivalentePK()); 
        CCuentaEquivalente cCuentaEquivalenteUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cCuentaEquivalenteActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cCuentaEquivalenteUpdated = cCuentaEquivalenteService.save(cCuentaEquivalente);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cConpes", cCuentaEquivalenteUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
