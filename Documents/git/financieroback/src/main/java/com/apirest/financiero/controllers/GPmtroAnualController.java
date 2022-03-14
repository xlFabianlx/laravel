package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GPmtroAnual;
import com.apirest.financiero.models.entity.GPmtroAnualPK;
import com.apirest.financiero.models.services.GPmtroAnualService;

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
public class GPmtroAnualController {

    @Autowired
    private GPmtroAnualService gPmtroAnualService;

    @GetMapping("/gpmtroanual/list")
    public List<GPmtroAnual> findAll(){
        return gPmtroAnualService.findAll();
    }

    @GetMapping("/gpmtroanual/id")
    public GPmtroAnual findById(@RequestBody GPmtroAnualPK gPmtroAnualPK){
        return gPmtroAnualService.findById(gPmtroAnualPK);
    }

    @PostMapping("/gpmtroanual/new")
    public ResponseEntity<?> create(@RequestBody GPmtroAnual gPmtroAnual){
        GPmtroAnual gPmtroAnualNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gPmtroAnualNew = gPmtroAnualService.save(gPmtroAnual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gPmtroAnualNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gpmtroanual/update")
    public ResponseEntity<?> update(@RequestBody GPmtroAnual gPmtroAnual){
        GPmtroAnual gPmtroAnualActual = gPmtroAnualService.findById(gPmtroAnual.getGPmtroAnualPK());
        GPmtroAnual gPmtroAnualUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gPmtroAnualActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gPmtroAnualUpdated  = gPmtroAnualService.save(gPmtroAnual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gPmtroAnualUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}