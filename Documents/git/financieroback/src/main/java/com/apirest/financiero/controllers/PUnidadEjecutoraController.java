package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.Punidadejecutora;
import com.apirest.financiero.models.services.PUnidadEjecutoraService;
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
public class PUnidadEjecutoraController {
    @Autowired
    private PUnidadEjecutoraService pUnidadEjecutoraService;

    @GetMapping("/unidadejecutora/list")
    public List<Punidadejecutora> findAll() {
        return pUnidadEjecutoraService.findAll();
    }


    @GetMapping("/unidadejecutora/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Short UniEje) {
        Punidadejecutora pRubroPtalIngreso;
        Map<String, Object> response = new HashMap<>();

        try {
            pRubroPtalIngreso = pUnidadEjecutoraService.findById(UniEje);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pRubroPtalIngreso == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Punidadejecutora>(pRubroPtalIngreso, HttpStatus.OK);
    }


    @PostMapping("/unidadejecutora/new")
    public ResponseEntity<?> create(@RequestBody Punidadejecutora pRubroPtalIngreso) {

        Punidadejecutora pRubroPtalIngresoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pRubroPtalIngresoNew = pUnidadEjecutoraService.save(pRubroPtalIngreso);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pRubroPtalIngresoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/unidadejecutora/updated")
    public ResponseEntity<?> update(@RequestBody Punidadejecutora pRubroPtalIngreso) {
        // Punidadejecutora pRubroPtalIngresoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pRubroPtalIngreso == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pRubroPtalIngreso != null) {
                response.put("ordendepago", pUnidadEjecutoraService.save(pRubroPtalIngreso));
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
