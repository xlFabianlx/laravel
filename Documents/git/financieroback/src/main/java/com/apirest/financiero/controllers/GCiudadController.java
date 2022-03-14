package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GCiudad;
import com.apirest.financiero.models.entity.GCiudadPK;
import com.apirest.financiero.models.services.GCiudadService;

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
public class GCiudadController {

    @Autowired
    private GCiudadService gCiudadService;

    @GetMapping("/ciudad/list")
    public List<GCiudad> findAll(){
        return gCiudadService.findAll();
    }

    @GetMapping("/ciudad/list/dptcod/{DptCod}")
    public List<GCiudad> findAll(@PathVariable("DptCod") Short DptCod){
        return gCiudadService.findByDptCod(DptCod);
    }
    
    @PostMapping("/ciudad/id")
    public GCiudad findById(@RequestBody GCiudadPK gCiudadPK){
        return gCiudadService.findById(gCiudadPK);
    }

    @PostMapping("/ciudad/new")
    public ResponseEntity<?> createGCiudad(@RequestBody GCiudad gCiudad){
        GCiudad gCiudadNew;
        Map<String, Object> response = new HashMap<>();
        try {
            gCiudadNew = gCiudadService.save(gCiudad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gCiudadNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/ciudad/update")
    public ResponseEntity<?> updated(@RequestBody GCiudad gCiudad){
        GCiudad gCiudadtActual = gCiudadService.findById(gCiudad.getGCiudadPK());
        GCiudad gCiudadUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gCiudadtActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gCiudadUpdated  = gCiudadService.save(gCiudad);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gCiudadUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}