package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GModalidadContrato;
import com.apirest.financiero.models.services.GModalidadContratoService;

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
public class GModalidadContratoController {

    @Autowired
    private GModalidadContratoService gModalidadContratoService;

    @GetMapping("/gmodalidad/list")
    public List<GModalidadContrato> findAll(){
        return gModalidadContratoService.findAll();
    }

    @GetMapping("/gmodalidad/{id}")
    public GModalidadContrato findById(@PathVariable("id") Short id){
        return gModalidadContratoService.findById(id);
    }

    @PostMapping("/gmodalidad/new")
    public ResponseEntity<?> create(@RequestBody GModalidadContrato gModalidadContrato){
        GModalidadContrato gModalidadContratoNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gModalidadContratoNew = gModalidadContratoService.save(gModalidadContrato);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gModalidadContratoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/gmodalidad/update")
    public ResponseEntity<?> update(@RequestBody GModalidadContrato gModalidadContrato, @PathVariable("id") Short id){
        GModalidadContrato gModalidadContratoActual = gModalidadContratoService.findById(id);
        GModalidadContrato gModalidadContratoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gModalidadContratoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gModalidadContratoUpdated  = gModalidadContratoService.save(gModalidadContrato);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gModalidadContratoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}