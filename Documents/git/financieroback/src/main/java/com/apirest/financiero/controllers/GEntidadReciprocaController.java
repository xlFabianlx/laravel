package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GEntidadReciproca;
import com.apirest.financiero.models.services.GEntidadReciprocaService;

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
public class GEntidadReciprocaController {

    @Autowired
    private GEntidadReciprocaService gEntidadReciprocaService;

    @GetMapping("/gentidadreciproca/list")
    public List<GEntidadReciproca> findAll(){
        return gEntidadReciprocaService.findAll();
    }

    @GetMapping("/gentidadreciproca/{id}")
    public GEntidadReciproca findById(@PathVariable("id") String id){
        return gEntidadReciprocaService.findById(id);
    }

    @PostMapping("/gentidadreciproca/new")
    public ResponseEntity<?> create (@RequestBody GEntidadReciproca gEntidadReciproca){
        GEntidadReciproca gEntidadReciprocaNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gEntidadReciprocaNew = gEntidadReciprocaService.save(gEntidadReciproca);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gEntidadReciprocaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gentidadreciproca/{id}")
    public ResponseEntity<?> updated(@RequestBody GEntidadReciproca gEntidadReciproca, @PathVariable("id") String id){
        GEntidadReciproca gEntidadReciprocaActual = gEntidadReciprocaService.findById(id);
        GEntidadReciproca gEntidadReciprocaUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gEntidadReciprocaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gEntidadReciprocaUpdated  = gEntidadReciprocaService.save(gEntidadReciproca);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gEntidadReciprocaUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    
}