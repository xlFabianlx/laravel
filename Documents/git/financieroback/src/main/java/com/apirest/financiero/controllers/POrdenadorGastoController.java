package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.POrdenadorGasto;
import com.apirest.financiero.models.services.POrdenadorGastoService;
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
public class POrdenadorGastoController {
    @Autowired
    private POrdenadorGastoService pOrdenadorGastoService;

    @GetMapping("/ordenadorgasto/list")
    public List<POrdenadorGasto> findAll() {
        return pOrdenadorGastoService.findAll();
    }


    @GetMapping("/ordenadorgasto/{id}")
    public ResponseEntity<?> show(@PathVariable("id") String ordCod) {
        POrdenadorGasto pOrdenadorGasto;
        Map<String, Object> response = new HashMap<>();

        try {
            pOrdenadorGasto = pOrdenadorGastoService.findById(ordCod);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pOrdenadorGasto == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<POrdenadorGasto>(pOrdenadorGasto, HttpStatus.OK);
    }


    @PostMapping("/ordenadorgasto/new")
    public ResponseEntity<?> create(@RequestBody POrdenadorGasto pOrdenadorGasto) {

        POrdenadorGasto pOrdenadorGastoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pOrdenadorGastoNew = pOrdenadorGastoService.save(pOrdenadorGasto);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pOrdenadorGastoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/ordenadorgasto/updated")
    public ResponseEntity<?> update(@RequestBody POrdenadorGasto pOrdenadorGasto) {
        // POrdenadorGasto pOrdenadorGastoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pOrdenadorGasto == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pOrdenadorGasto != null) {
                response.put("ordendepago", pOrdenadorGastoService.save(pOrdenadorGasto));
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
