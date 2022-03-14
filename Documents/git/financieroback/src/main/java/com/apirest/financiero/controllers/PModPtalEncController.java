package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PModPtalEnc;
import com.apirest.financiero.models.entity.PModPtalEncPK;
import com.apirest.financiero.models.services.PModPtalEncService;
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
public class PModPtalEncController {
    @Autowired
    private PModPtalEncService pModPtalEncService;

    @GetMapping("/modptalenc/list")
    public List<PModPtalEnc> findAll() {
        return pModPtalEncService.findAll();
    }


    @GetMapping("/modptalenc/pk")
    public ResponseEntity<?> show(@RequestBody PModPtalEncPK pModPtalEncPK) {
        PModPtalEnc pModPtalEnc;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtalEnc = pModPtalEncService.findById(pModPtalEncPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pModPtalEnc == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PModPtalEnc>(pModPtalEnc, HttpStatus.OK);
    }


    @PostMapping("/modptalenc/new")
    public ResponseEntity<?> create(@RequestBody PModPtalEnc pModPtalEnc) {

        PModPtalEnc pModPtalEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pModPtalEncNew = pModPtalEncService.save(pModPtalEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pModPtalEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/modptalenc/updated")
    public ResponseEntity<?> update(@RequestBody PModPtalEnc pModPtalEnc) {
        PModPtalEnc pModPtalEncActual = pModPtalEncService.findById(pModPtalEnc.getPModPtalEncPK());
        PModPtalEnc pModPtalEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pModPtalEncActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pModPtalEncActual.setMovEst(pModPtalEnc.getMovEst());
            pModPtalEncActual.setMovFecAnu(pModPtalEnc.getMovFecAnu());
            pModPtalEncActual.setMovHorAnu(pModPtalEnc.getMovHorAnu());
            pModPtalEncActual.setMovCsaAnu(pModPtalEnc.getMovCsaAnu());
            pModPtalEncActual.setMovUsuAnu(pModPtalEnc.getMovUsuAnu());
            pModPtalEncActual.setDecCod(pModPtalEnc.getDecCod());
            pModPtalEncActual.setMovUsu(pModPtalEnc.getMovUsu());
            pModPtalEncActual.setMovfec(pModPtalEnc.getMovfec());
            pModPtalEncActual.setMovHor(pModPtalEnc.getMovHor());
            pModPtalEncActual.setEntMovimiento(pModPtalEnc.getEntMovimiento());

            pModPtalEncUpdated = pModPtalEncService.save(pModPtalEncActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pModPtalEncUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
