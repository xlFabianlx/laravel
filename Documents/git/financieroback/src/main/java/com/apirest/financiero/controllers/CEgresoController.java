package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CEgreso;
import com.apirest.financiero.models.entity.CEgresoPK;
import com.apirest.financiero.models.services.CEgresoService;

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
public class CEgresoController {

    @Autowired
    private CEgresoService cEgresoService;

    @GetMapping("/cegreso/list")
    public List<CEgreso> findAll() {
        return cEgresoService.findAll();
    }

    @GetMapping("/cegreso/codigo/{egrCod}")
    public CEgreso findByEgrCod(@PathVariable("egrCod") Integer egrCod) {
        return cEgresoService.findByEgrCod(egrCod);
    }

    @GetMapping("/cegreso/pk")
    public ResponseEntity<?> show(@RequestBody CEgresoPK cEgresoPK) {
        CEgreso CEgresoActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CEgresoActual = cEgresoService.findByPK(cEgresoPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CEgresoActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CEgreso>(CEgresoActual, HttpStatus.OK);
    }

    @PostMapping("/cegreso/new")
    public ResponseEntity<?> create(@RequestBody CEgreso cEgreso) {

        CEgreso cEgresoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cEgresoNew = cEgresoService.save(cEgreso);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cEgresoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cegreso/updated")
    public ResponseEntity<?> update(@RequestBody  CEgreso cEgreso) {
        CEgreso cEgresoActual = cEgresoService.findByPK(cEgreso.getCEgresoPK()); 
        CEgreso cEgresoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cEgresoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cEgresoUpdated = cEgresoService.save(cEgreso);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cEgresoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
