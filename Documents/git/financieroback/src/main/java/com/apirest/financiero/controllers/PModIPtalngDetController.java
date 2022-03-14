package com.apirest.financiero.controllers;



import com.apirest.financiero.models.entity.PModIPtalngDet;
import com.apirest.financiero.models.entity.PModIPtalngDetPK;
import com.apirest.financiero.models.services.PModIPtalngDetService;
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
public class PModIPtalngDetController {
    @Autowired
    private PModIPtalngDetService pModIPtalngDetService;

    @GetMapping("/modiptalngdet/list")
    public List<PModIPtalngDet> findAll() {
        return pModIPtalngDetService.findAll();
    }


    @GetMapping("/modiptalngdet/pk")
    public ResponseEntity<?> show(@RequestBody PModIPtalngDetPK pModIPtalngDetPK) {
        PModIPtalngDet pModIPtalngDet;
        Map<String, Object> response = new HashMap<>();

        try {
            pModIPtalngDet = pModIPtalngDetService.findById(pModIPtalngDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pModIPtalngDet == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PModIPtalngDet>(pModIPtalngDet, HttpStatus.OK);
    }


    @PostMapping("/modiptalngdet/new")
    public ResponseEntity<?> create(@RequestBody PModIPtalngDet pModIPtalngDet) {

        PModIPtalngDet pModIPtalngDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pModIPtalngDetNew = pModIPtalngDetService.save(pModIPtalngDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pModIPtalngDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/modiptalngdet/updated")
    public ResponseEntity<?> update(@RequestBody PModIPtalngDet pModIPtalngDet) {
        PModIPtalngDet pModIPtalngDetActual = pModIPtalngDetService.findById(pModIPtalngDet.getPModIPtalngDetPK());
        PModIPtalngDet pModIPtalngDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pModIPtalngDetActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pModIPtalngDetActual.setDetIAdiVlr(pModIPtalngDet.getDetIAdiVlr());
            pModIPtalngDetActual.setDetIRecVlr(pModIPtalngDet.getDetIRecVlr());
            pModIPtalngDetActual.setDetITrVlrd(pModIPtalngDet.getDetITrVlrd());
            pModIPtalngDetActual.setDetITrVlrh(pModIPtalngDet.getDetITrVlrh());
            pModIPtalngDetActual.setDetIPac01(pModIPtalngDet.getDetIPac01());
            pModIPtalngDetActual.setDetIPac02(pModIPtalngDet.getDetIPac02());
            pModIPtalngDetActual.setDetIPac03(pModIPtalngDet.getDetIPac03());
            pModIPtalngDetActual.setDetIPac04(pModIPtalngDet.getDetIPac04());
            pModIPtalngDetActual.setDetIPac05(pModIPtalngDet.getDetIPac05());
            pModIPtalngDetActual.setDetIPac06(pModIPtalngDet.getDetIPac06());
            pModIPtalngDetActual.setDetIPac07(pModIPtalngDet.getDetIPac07());
            pModIPtalngDetActual.setDetIPac08(pModIPtalngDet.getDetIPac08());
            pModIPtalngDetActual.setDetIPac09(pModIPtalngDet.getDetIPac01());
            pModIPtalngDetActual.setDetIPac10(pModIPtalngDet.getDetIPac10());
            pModIPtalngDetActual.setDetIPac11(pModIPtalngDet.getDetIPac11());
            pModIPtalngDetActual.setDetIPac12(pModIPtalngDet.getDetIPac12());
            pModIPtalngDetActual.setDetITrVlrhas(pModIPtalngDet.getDetITrVlrhas());
            pModIPtalngDetActual.setDetITrVlrdes(pModIPtalngDet.getDetITrVlrdes());

            pModIPtalngDetUpdated = pModIPtalngDetService.save(pModIPtalngDetActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pModIPtalngDetUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
