package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GDpto;
import com.apirest.financiero.models.services.GDptoService;

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
public class GDptoController {

    @Autowired
    private GDptoService gDptoService;

    @GetMapping("/gdpto/list")
    public List<GDpto> findAll(){
        return gDptoService.findAll();
    }

    @GetMapping("/gdpto/{id}")
    public GDpto findById(@PathVariable("id") short id){
        return gDptoService.findById(id);
    }

    @PostMapping("/gdpto/new")
    public ResponseEntity<?> create(@RequestBody GDpto gDpto){
        GDpto gDptoNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gDptoNew = gDptoService.save(gDpto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gDptoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gdpto/{id}")
    public ResponseEntity<?> updated(@RequestBody GDpto gDpto, @PathVariable("id") Short id){
        GDpto gDptoActual = gDptoService.findById(id);
        GDpto gDptoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gDptoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gDptoUpdated  = gDptoService.save(gDpto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gDptoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}