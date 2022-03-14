package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PFuenteFinanciacion;
import com.apirest.financiero.models.services.PFuenteFinanciacionService;
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
public class PFuenteFinanciacionController {
    @Autowired
    private PFuenteFinanciacionService pFuenteFinanciacionService;


    @GetMapping("/fuentefinanciacion/list")
    public List<PFuenteFinanciacion> findAll() {
        return pFuenteFinanciacionService.findAll();
    }

    @GetMapping("/fuentefinanciacion/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Short fueCod) {
        PFuenteFinanciacion pFuenteFinanciacion;
        Map<String, Object> response = new HashMap<>();

        try {
            pFuenteFinanciacion = pFuenteFinanciacionService.findById(fueCod);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pFuenteFinanciacion == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PFuenteFinanciacion>(pFuenteFinanciacion, HttpStatus.OK);
    }

    @PostMapping("/fuentefinanciacion/new")
    public ResponseEntity<?> create(@RequestBody PFuenteFinanciacion pFuenteFinanciacion) {

        PFuenteFinanciacion pFuenteFinanciacionNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pFuenteFinanciacionNew = pFuenteFinanciacionService.save(pFuenteFinanciacion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pFuenteFinanciacionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/fuentefinanciacion/updated")
    public ResponseEntity<?> update(@RequestBody PFuenteFinanciacion pFuenteFinanciacion) {
        PFuenteFinanciacion pFuenteFinanciacionActual = pFuenteFinanciacionService.findById(pFuenteFinanciacion.getFueCod());
        PFuenteFinanciacion pFuenteFinanciacionUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pFuenteFinanciacionActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pFuenteFinanciacionActual.setFueDes(pFuenteFinanciacion.getFueDes());
            pFuenteFinanciacionUpdated = pFuenteFinanciacionService.save(pFuenteFinanciacionActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pFuenteFinanciacionUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
