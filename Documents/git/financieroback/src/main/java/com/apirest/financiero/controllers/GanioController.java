package com.apirest.financiero.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.Ganio;
import com.apirest.financiero.models.entity.GanioPK;
import com.apirest.financiero.models.services.GanioService;

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
public class GanioController {

    @Autowired
    private GanioService ganioService;


    @GetMapping("/ganio/list")
    public List<Ganio> findAll(){
        return ganioService.findAll();
    }

    @GetMapping("/ganio/id")
    public Ganio findById(@RequestBody GanioPK ganioPK ){
        return ganioService.findById(ganioPK);
    }

    @PostMapping("/ganio/new")
    public ResponseEntity<?> createGanio(@RequestBody Ganio ganio){
        Ganio ganioNew;
        Map<String, Object> response = new HashMap<>();
        try {
            ganioNew = ganioService.save(ganio);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", ganioNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/ganio/updated")
    public ResponseEntity<?> update(@RequestBody Ganio ganio ){
        Ganio ganiotActual = ganioService.findById(ganio.getGanioPK());
        Ganio ganioUpdated;

        Map<String, Object> response = new HashMap<>();

        if (ganiotActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            ganioUpdated  = ganioService.save(ganio);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", ganioUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }
    
}