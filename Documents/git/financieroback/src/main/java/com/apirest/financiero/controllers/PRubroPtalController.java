package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PRubroPtal;
import com.apirest.financiero.models.entity.PRubroPtalPK;
import com.apirest.financiero.models.services.PRubroPtalService;
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
public class PRubroPtalController {
    @Autowired
    private PRubroPtalService pRubroPtalService;

    @GetMapping("/rubropetal/list")
    public List<PRubroPtal> findAll() {
        return pRubroPtalService.findAll();
    }


    @GetMapping("/rubropetal/pk")
    public ResponseEntity<?> show(@RequestBody PRubroPtalPK pRubroPtalPK) {
        PRubroPtal pRubroPtal;
        Map<String, Object> response = new HashMap<>();

        try {
            pRubroPtal = pRubroPtalService.findById(pRubroPtalPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pRubroPtal == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PRubroPtal>(pRubroPtal, HttpStatus.OK);
    }


    @PostMapping("/rubropetal/new")
    public ResponseEntity<?> create(@RequestBody PRubroPtal pRubroPtal) {

        PRubroPtal pRubroPtalNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pRubroPtalNew = pRubroPtalService.save(pRubroPtal);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pRubroPtalNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/rubropetal/update")
    public ResponseEntity<?> update(@RequestBody PRubroPtal pRubroPtal) {
        PRubroPtal pRubroPtalActual = pRubroPtalService.findById(pRubroPtal.getPRubroPtalPK());
        PRubroPtal pRubroPtalUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pRubroPtalActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pRubroPtalUpdated = pRubroPtalService.save(pRubroPtal);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pRubroPtalUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/rubroptal/conFuentes/list")
    public List<PRubroPtal> findAllRubrosConFuente() {
        return pRubroPtalService.findAllRubrosConFuente();
    }

}
