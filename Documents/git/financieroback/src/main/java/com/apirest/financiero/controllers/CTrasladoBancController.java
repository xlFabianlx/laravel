package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CTrasladoBanc;
import com.apirest.financiero.models.entity.CTrasladoBancPK;
import com.apirest.financiero.models.services.CTrasladoBancService;

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
public class CTrasladoBancController {

    @Autowired
    private CTrasladoBancService cTrasladoBancService;

    @GetMapping("/ctraslado/banco/list")
    public List<CTrasladoBanc> findAll() {
        return cTrasladoBancService.findAll();
    }

    @GetMapping("/ctraslado/banco/pk")
    public ResponseEntity<?> show(@RequestBody CTrasladoBancPK cTrasladoBancPK) {
        CTrasladoBanc cTrasladoBancActual;
        Map<String, Object> response = new HashMap<>();

        try {
            cTrasladoBancActual = cTrasladoBancService.findByPK(cTrasladoBancPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cTrasladoBancActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CTrasladoBanc>(cTrasladoBancActual, HttpStatus.OK);
    }

    @PostMapping("/ctraslado/banco/new")
    public ResponseEntity<?> create(@RequestBody CTrasladoBanc cTrasladoBanc) {

        CTrasladoBanc cTrasladoBancNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cTrasladoBancNew = cTrasladoBancService.save(cTrasladoBanc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cTrasladoBancNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/ctraslado/banco/updated")
    public ResponseEntity<?> update(@RequestBody CTrasladoBanc cTrasladoBanc) {
        CTrasladoBanc cTrasladoBancActual = cTrasladoBancService.findByPK(cTrasladoBanc.getCTrasladoBancPK());
        CTrasladoBanc cTrasladoBancUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cTrasladoBancActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cTrasladoBancUpdated = cTrasladoBancService.save(cTrasladoBanc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cTrasladoBancUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
