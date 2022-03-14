package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GDocOficial;
import com.apirest.financiero.models.entity.GDocOficialPK;
import com.apirest.financiero.models.services.GDocOficialService;

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
public class GDocOficialController {

    @Autowired
    private GDocOficialService gDocOficialService;

    @GetMapping("/gdocoficial/list")
    public List<GDocOficial> findAll(){
        return gDocOficialService.findAll();
    }

    @GetMapping("/gdocoficial/id")
    public GDocOficial findById(@RequestBody GDocOficialPK gDocOficialPK){
        return gDocOficialService.findById(gDocOficialPK);
    }

    @PostMapping("/gdocoficial/new")
    public ResponseEntity<?> create(@RequestBody GDocOficial gDocOficial){
        GDocOficial gDocOficialNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gDocOficialNew = gDocOficialService.save(gDocOficial);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gDocOficialNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gdocoficial/update")
    public ResponseEntity<?> updated(@RequestBody GDocOficial gDocOficial){
        GDocOficial gDocOficialActual = gDocOficialService.findById(gDocOficial.getGDocOficialPK());
        GDocOficial gDocOficialUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gDocOficialActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gDocOficialUpdated  = gDocOficialService.save(gDocOficial);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gDocOficialUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}