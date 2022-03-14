package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GDocAuditoria;
import com.apirest.financiero.models.entity.GDocAuditoriaPK;
import com.apirest.financiero.models.services.GDocAuditoriaService;

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

public class GDocAuditoriaController {

    @Autowired
    private GDocAuditoriaService gDocAuditoriaService;

    @GetMapping("/gdocauditoria/list")
    public List<GDocAuditoria> findAll(){
        return gDocAuditoriaService.findAll();
    }

    @GetMapping("/gdocauditoria/id")
    public GDocAuditoria findById(@RequestBody GDocAuditoriaPK gDocAuditoriaPK){
        return gDocAuditoriaService.findById(gDocAuditoriaPK);
    }

    @PostMapping("/gdocauditoria/new")
    public ResponseEntity<?> create(@RequestBody GDocAuditoria gDocAuditoria){
        GDocAuditoria gDocAuditoriaNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gDocAuditoriaNew = gDocAuditoriaService.save(gDocAuditoria);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gDocAuditoriaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gdocauditoria/update")
    public ResponseEntity<?> update(@RequestBody GDocAuditoria gDocAuditoria){
        GDocAuditoria gDocAuditoriaActual = gDocAuditoriaService.findById(gDocAuditoria.getGDocAuditoriaPK());
        GDocAuditoria gDocAuditoriapdated;

        Map<String, Object> response = new HashMap<>();

        if (gDocAuditoriaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gDocAuditoriapdated  = gDocAuditoriaService.save(gDocAuditoria);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gDocAuditoriapdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}