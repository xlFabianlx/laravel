package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PModPtaIngEnc;
import com.apirest.financiero.models.entity.PModPtaIngEncPK;
import com.apirest.financiero.models.services.PModPtaIngEncService;
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
public class PModPtaIngEncController {
    @Autowired
    private PModPtaIngEncService pModPtaIngEncService;

    @GetMapping("/modiptalngenc/list")
    public List<PModPtaIngEnc> findAll() {
        return pModPtaIngEncService.findAll();
    }


    @GetMapping("/modiptalngenc/pk")
    public ResponseEntity<?> show(@RequestBody PModPtaIngEncPK pModPtaIngEncPK) {
        PModPtaIngEnc pModPtaIngEnc;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtaIngEnc = pModPtaIngEncService.findById(pModPtaIngEncPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pModPtaIngEnc == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PModPtaIngEnc>(pModPtaIngEnc, HttpStatus.OK);
    }


    @PostMapping("/modiptalngenc/new")
    public ResponseEntity<?> create(@RequestBody PModPtaIngEnc pModPtaIngEnc) {

        PModPtaIngEnc pModPtaIngEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtaIngEncNew = pModPtaIngEncService.save(pModPtaIngEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pModPtaIngEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/modiptalngenc/updated")
    public ResponseEntity<?> update(@RequestBody PModPtaIngEnc pModPtaIngEnc) {
        PModPtaIngEnc pModPtaIngEncActual = pModPtaIngEncService.findById(pModPtaIngEnc.getPModPtaIngEncPK());
        PModPtaIngEnc pModPtaIngEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pModPtaIngEncActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {

            pModPtaIngEncActual.setMovIHorAnu(pModPtaIngEnc.getMovIHorAnu());
            pModPtaIngEncActual.setMovIUsuAnu(pModPtaIngEnc.getMovIUsuAnu());
            pModPtaIngEncActual.setMovIFec(pModPtaIngEnc.getMovIFec());
            pModPtaIngEncActual.setMovIUsu(pModPtaIngEnc.getMovIUsu());
            pModPtaIngEncActual.setMovIHor(pModPtaIngEnc.getMovIHor());
            pModPtaIngEncActual.setMovIest(pModPtaIngEnc.getMovIest());
            pModPtaIngEncActual.setMovICsaAnu(pModPtaIngEnc.getMovICsaAnu());
            pModPtaIngEncActual.setMovIMvr(pModPtaIngEnc.getMovIMvr());
            pModPtaIngEncActual.setDecCod(pModPtaIngEnc.getDecCod());

            pModPtaIngEncUpdated = pModPtaIngEncService.save(pModPtaIngEncActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pModPtaIngEncUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
