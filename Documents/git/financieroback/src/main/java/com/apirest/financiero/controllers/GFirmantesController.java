package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GFirmantes;
import com.apirest.financiero.models.entity.GFirmantesPK;
import com.apirest.financiero.models.services.GFirmantesService;

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
public class GFirmantesController {

    @Autowired
    private GFirmantesService gFirmantesService;

    @GetMapping("/gfirmantes/list")
    public List<GFirmantes> findAll(){
        return gFirmantesService.findAll();
    }

    @GetMapping("/gfirmantes/id")
    public GFirmantes findById(@RequestBody GFirmantesPK gFirmantesPK){
        return gFirmantesService.findById(gFirmantesPK);
    }

    @PostMapping("/gfirmantes/new")
    public ResponseEntity<?> create(@RequestBody GFirmantes gFirmantes){
        GFirmantes gFirmantesNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gFirmantesNew = gFirmantesService.save(gFirmantes);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gFirmantesNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gfirmantes/update")
    public  ResponseEntity<?> updated(@RequestBody GFirmantes gFirmantes){
        GFirmantes gFirmantesActual = gFirmantesService.findById(gFirmantes.getGFirmantesPK());
        GFirmantes gFirmantesUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gFirmantesActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gFirmantesUpdated  = gFirmantesService.save(gFirmantes);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gFirmantesUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}