package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PSectorPtal;
import com.apirest.financiero.models.services.PSectorPtalService;
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
public class PSectorPtalController {
    @Autowired
    private PSectorPtalService pSectorPtalService;

    @GetMapping("/sectorptal/list")
    public List<PSectorPtal> findAll() {
        return pSectorPtalService.findAll();
    }


    @GetMapping("/sectorptal/{id}")
    public ResponseEntity<?> show(@PathVariable("id") String sectorcodigo) {
        PSectorPtal pSectorPtal;
        Map<String, Object> response = new HashMap<>();

        try {
            pSectorPtal = pSectorPtalService.findById(sectorcodigo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pSectorPtal == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PSectorPtal>(pSectorPtal, HttpStatus.OK);
    }


    @PostMapping("/sectorptal/new")
    public ResponseEntity<?> create(@RequestBody PSectorPtal pSectorPtal) {

        PSectorPtal pSectorPtalnNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pSectorPtalnNew = pSectorPtalService.save(pSectorPtal);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pSectorPtalnNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/sectorptal/updated")
    public ResponseEntity<?> update(@RequestBody PSectorPtal pSectorPtal) {
        // PSectorPtal pSectorPtalUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pSectorPtal == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pSectorPtal != null) {
                response.put("ordendepago", pSectorPtalService.save(pSectorPtal));
            }

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
