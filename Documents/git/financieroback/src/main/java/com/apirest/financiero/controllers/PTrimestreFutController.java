package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PTrimestreFut;
import com.apirest.financiero.models.entity.PTrimestreFutPK;
import com.apirest.financiero.models.services.PTrimestreFutService;
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
public class PTrimestreFutController {
    @Autowired
    private PTrimestreFutService pTrimestreFutService;

    @GetMapping("/trimestrefut/list")
    public List<PTrimestreFut> findAll() {
        return pTrimestreFutService.findAll();
    }


    @GetMapping("/trimestrefut/pk")
    public ResponseEntity<?> show(@RequestBody PTrimestreFutPK pTrimestreFutPK) {
        PTrimestreFut pTrimestreFut;
        Map<String, Object> response = new HashMap<>();

        try {
            pTrimestreFut = pTrimestreFutService.findById(pTrimestreFutPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pTrimestreFut == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PTrimestreFut>(pTrimestreFut, HttpStatus.OK);
    }


    @PostMapping("/trimestrefut/new")
    public ResponseEntity<?> create(@RequestBody PTrimestreFut pTrimestreFut) {

        PTrimestreFut pTrimestreFutNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pTrimestreFutNew = pTrimestreFutService.save(pTrimestreFut);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pTrimestreFutNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/trimestrefut/updated")
    public ResponseEntity<?> update(@RequestBody PTrimestreFut pTrimestreFut) {
        // PTrimestreFut pTrimestreFutUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pTrimestreFut == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pTrimestreFut != null) {
                response.put("ordendepago", pTrimestreFutService.save(pTrimestreFut));
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
