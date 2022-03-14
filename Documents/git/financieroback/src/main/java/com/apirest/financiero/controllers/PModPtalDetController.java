package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PModPtalDet;
import com.apirest.financiero.models.entity.PModPtalDetPK;
import com.apirest.financiero.models.services.PModPtalDetService;
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
public class PModPtalDetController {
    @Autowired
    private PModPtalDetService pModPtalDetService;

    @GetMapping("/modptadet/list")
    public List<PModPtalDet> findAll() {
        return pModPtalDetService.findAll();
    }


    @GetMapping("/modptadet/pk")
    public ResponseEntity<?> show(@RequestBody PModPtalDetPK pModPtalDetPK) {
        PModPtalDet pModPtalDet;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtalDet = pModPtalDetService.findById(pModPtalDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pModPtalDet == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PModPtalDet>(pModPtalDet, HttpStatus.OK);
    }


    @PostMapping("/modptadet/new")
    public ResponseEntity<?> create(@RequestBody PModPtalDet pModPtalDet) {

        PModPtalDet pModPtalDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtalDetNew = pModPtalDetService.save(pModPtalDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pModPtalDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/modptadet/updated")
    public ResponseEntity<?> update(@RequestBody PModPtalDet pModPtalDet) {
        PModPtalDet pModPtalDetActual = pModPtalDetService.findById(pModPtalDet.getPModPtalDetPK());
        PModPtalDet pModPtalDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pModPtalDetActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pModPtalDetActual.setDetAdiVlr(pModPtalDet.getDetAdiVlr());
            pModPtalDetActual.setDetRecVlr(pModPtalDet.getDetRecVlr());
            pModPtalDetActual.setDetTraVlrdes(pModPtalDet.getDetTraVlrdes());
            pModPtalDetActual.setDetTraVlrhas(pModPtalDet.getDetTraVlrhas());
            pModPtalDetActual.setDetPac01(pModPtalDet.getDetPac01());
            pModPtalDetActual.setDetPac02(pModPtalDet.getDetPac02());
            pModPtalDetActual.setDetPac03(pModPtalDet.getDetPac03());
            pModPtalDetActual.setDetPac04(pModPtalDet.getDetPac04());
            pModPtalDetActual.setDetPac05(pModPtalDet.getDetPac05());
            pModPtalDetActual.setDetPac06(pModPtalDet.getDetPac06());
            pModPtalDetActual.setDetPac07(pModPtalDet.getDetPac07());
            pModPtalDetActual.setDetPac08(pModPtalDet.getDetPac08());
            pModPtalDetActual.setDetPac09(pModPtalDet.getDetPac09());
            pModPtalDetActual.setDetPac10(pModPtalDet.getDetPac10());
            pModPtalDetActual.setDetPac11(pModPtalDet.getDetPac11());
            pModPtalDetActual.setDetPac12(pModPtalDet.getDetPac12());

            pModPtalDetUpdated = pModPtalDetService.save(pModPtalDetActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pModPtalDetUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
