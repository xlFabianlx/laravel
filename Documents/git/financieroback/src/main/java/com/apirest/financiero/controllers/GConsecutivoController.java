package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GConsecutivo;
import com.apirest.financiero.models.entity.GConsecutivoPK;
import com.apirest.financiero.models.services.GConsecutivoService;

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
public class GConsecutivoController {

    @Autowired
    private GConsecutivoService gConsecutivoService;

    @GetMapping("/consecutivo/list")
    public List<GConsecutivo> findAll(){
        return gConsecutivoService.findAll();
    }

    @GetMapping("/consecutivo/id")
    public GConsecutivo findById(@RequestBody GConsecutivoPK gConsecutivoPK){
        return gConsecutivoService.findById(gConsecutivoPK);
    }

    @PostMapping("/consecutivo/new")
    public ResponseEntity<?> create(@RequestBody GConsecutivo gConsecutivo){
        GConsecutivo gConsecutivoNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gConsecutivoNew = gConsecutivoService.save(gConsecutivo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gConsecutivoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/consecutivo/update")
    public ResponseEntity<?> update(@RequestBody GConsecutivo gConsecutivo){
        GConsecutivo gConsecutivoActual = gConsecutivoService.findById(gConsecutivo.getGConsecutivoPK());
        GConsecutivo gConsecutivoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gConsecutivoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gConsecutivoUpdated  = gConsecutivoService.save(gConsecutivo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gConsecutivoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}