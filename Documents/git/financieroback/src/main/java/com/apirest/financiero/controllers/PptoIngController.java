package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PptoIng;
import com.apirest.financiero.models.entity.PptoIngPK;
import com.apirest.financiero.models.services.PptoIngService;
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
public class PptoIngController {
    @Autowired
    private PptoIngService pptoIngService;

    @GetMapping("/ptoing/list")
    public List<PptoIng> findAll() {
        return pptoIngService.findAll();
    }


    @GetMapping("/ptoing/pk")
    public ResponseEntity<?> show(@RequestBody PptoIngPK pptoIngPK) {
        PptoIng pptoIng;
        Map<String, Object> response = new HashMap<>();

        try {
            pptoIng = pptoIngService.findById(pptoIngPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pptoIng == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PptoIng>(pptoIng, HttpStatus.OK);
    }


    @PostMapping("/ptoing/new")
    public ResponseEntity<?> create(@RequestBody PptoIng pptoIng) {

        PptoIng pptoIngNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pptoIngNew = pptoIngService.save(pptoIng);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pptoIngNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/ptoing/updated")
    public ResponseEntity<?> update(@RequestBody PptoIng pptoIng) {
        // PptoIng pptoIngUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pptoIng == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pptoIng != null) {
                response.put("ordendepago", pptoIngService.save(pptoIng));
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
