package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PCertDispPtalDet;
import com.apirest.financiero.models.entity.PCertDispPtalDetPK;
import com.apirest.financiero.models.services.PCertDispPtalDetService;
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
public class PCertDispPtalDetController {
    @Autowired
    private PCertDispPtalDetService pCertDispPtalDetService;


    @GetMapping("/certdispptalpdet/list")
    public List<PCertDispPtalDet> findAll() {
        return pCertDispPtalDetService.findAll();
    }


    @GetMapping("/certdispptalpdet/pk")
    public ResponseEntity<?> show(@RequestBody PCertDispPtalDetPK pCertDispPtalDetPK) {
        PCertDispPtalDet pCertDispPtalDet;
        Map<String, Object> response = new HashMap<>();

        try {
            pCertDispPtalDet = pCertDispPtalDetService.findById(pCertDispPtalDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pCertDispPtalDet == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PCertDispPtalDet>(pCertDispPtalDet, HttpStatus.OK);
    }


    @PostMapping("/certdispptalpdet/new")
    public ResponseEntity<?> create(@RequestBody PCertDispPtalDet pCertDispPtalDet) {

        PCertDispPtalDet pCertDispPtalDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pCertDispPtalDetNew = pCertDispPtalDetService.save(pCertDispPtalDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pCertDispPtalDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/certdispptalpdet/updated")
    public ResponseEntity<?> update(@RequestBody PCertDispPtalDet pCertDispPtalDet) {
        PCertDispPtalDet pCertDispPtalDetActual = pCertDispPtalDetService.findById(pCertDispPtalDet.getPCertDispPtalDetPK());
        PCertDispPtalDet pCertDispPtalDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pCertDispPtalDetActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pCertDispPtalDetActual.setDetCdpVlr(pCertDispPtalDet.getDetCdpVlr());
            pCertDispPtalDetActual.setDetComp(pCertDispPtalDet.getDetComp());
            pCertDispPtalDetActual.setDetLibr(pCertDispPtalDet.getDetLibr());
            pCertDispPtalDetUpdated = pCertDispPtalDetService.save(pCertDispPtalDetActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pCertDispPtalDetUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
