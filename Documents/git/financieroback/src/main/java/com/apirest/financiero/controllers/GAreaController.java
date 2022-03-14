package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GArea;
import com.apirest.financiero.models.services.GAreaService;

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

public class GAreaController {
     
    @Autowired
    private GAreaService gAreaService;

    @GetMapping("/garea/list")
    public List<GArea> findAll(){
        return gAreaService.findAll();
    }

    @GetMapping("/garea/{id}")
    public GArea findById(@PathVariable("id") short id){
        return gAreaService.findById(id);
    }

    @PostMapping("/garea/new")
    public ResponseEntity<?> create(@RequestBody GArea gArea){
        GArea gAreaNew;

        Map<String, Object> response = new HashMap<>();

        try {
            gAreaNew = gAreaService.save(gArea);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gAreaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/garea/{id}")
    public ResponseEntity<?> update(@RequestBody GArea gArea, @PathVariable("id") short id){
        GArea gAreaActual = gAreaService.findById(id);
        GArea gAreaUpdated = null;

        Map<String, Object> response = new HashMap<>();

        if (gAreaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el Area actual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gAreaUpdated  = gAreaService.save(gArea);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Area contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gAreaUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}