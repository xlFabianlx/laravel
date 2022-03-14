package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GEntidad;
import com.apirest.financiero.models.entity.GEntidadPK;
import com.apirest.financiero.models.services.GEntidadService;

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
public class GEntidadController {

    @Autowired
    private GEntidadService gEntidadService;

    @GetMapping("/gentidad/list")
    public List<GEntidad> findAll(){
        return gEntidadService.findAll();
    }

    @GetMapping("/gentidad/id")
    public GEntidad findById(@RequestBody GEntidadPK gEntidadPK){
        return gEntidadService.findById(gEntidadPK);
    }

    @PostMapping("/gentidad/new")
    public ResponseEntity<?> create(@RequestBody GEntidad gEntidad){
        GEntidad gEntidadNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gEntidadNew = gEntidadService.save(gEntidad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gEntidadNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gentidad/update")
    public ResponseEntity<?> updated(@RequestBody GEntidad gEntidad){
        GEntidad gEntidadActual = gEntidadService.findById(gEntidad.getGEntidadPK());
        GEntidad gEntidadUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gEntidadActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gEntidadUpdated  = gEntidadService.save(gEntidad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gEntidadUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}