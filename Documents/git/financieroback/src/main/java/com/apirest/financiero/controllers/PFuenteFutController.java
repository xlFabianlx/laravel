package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PFuenteFut;
import com.apirest.financiero.models.entity.PFuenteFutPK;
import com.apirest.financiero.models.services.PFuenteFutService;
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
public class PFuenteFutController {
    @Autowired
    private PFuenteFutService pFuenteFutService;

    @GetMapping
            ("/fuentefut/list")
    public List<PFuenteFut> findAll() {
        return pFuenteFutService.findAll();
    }


    @GetMapping("/fuentefut/pk")
    public ResponseEntity<?> show(@RequestBody PFuenteFutPK pFuenteFutPK) {
        PFuenteFut pFuenteFut;
        Map<String, Object> response = new HashMap<>();

        try {
            pFuenteFut = pFuenteFutService.findById(pFuenteFutPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pFuenteFut == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PFuenteFut>(pFuenteFut, HttpStatus.OK);
    }


    @PostMapping("/fuentefut/new")
    public ResponseEntity<?> create(@RequestBody PFuenteFut pFuenteFut) {

        PFuenteFut pFuenteFutNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pFuenteFutNew = pFuenteFutService.save(pFuenteFut);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pFuenteFutNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/fuentefut/updated")
    public ResponseEntity<?> update(@RequestBody PFuenteFut pFuenteFut) {
        PFuenteFut pFuenteFutActual = pFuenteFutService.findById(pFuenteFut.getPFuenteFutPK());
        PFuenteFut pFuenteFutUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pFuenteFutActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pFuenteFutActual.setFutFueNom(pFuenteFut.getFutFueNom());
            pFuenteFutUpdated = pFuenteFutService.save(pFuenteFutActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pFuenteFutUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
