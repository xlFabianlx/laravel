package com.apirest.financiero.controllers;


import com.apirest.financiero.models.entity.PRegPreEnc;
import com.apirest.financiero.models.entity.PRegPreEncPK;
import com.apirest.financiero.models.services.PRegPreEncService;
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
public class PRegPreEncController {
    @Autowired
    private PRegPreEncService pRegPreEncService;

    @GetMapping("/regpreenc/list")
    public List<PRegPreEnc> findAll() {
        return pRegPreEncService.findAll();
    }


    @GetMapping("/regpreenc/pk")
    public ResponseEntity<?> show(@RequestBody PRegPreEncPK pRegPreEncPK) {
        PRegPreEnc pRegPreEnc;
        Map<String, Object> response = new HashMap<>();

        try {
            pRegPreEnc = pRegPreEncService.findById(pRegPreEncPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pRegPreEnc == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PRegPreEnc>(pRegPreEnc, HttpStatus.OK);
    }


    @PostMapping("/regpreenc/new")
    public ResponseEntity<?> create(@RequestBody PRegPreEnc pRegPreEnc) {

        PRegPreEnc pRegPreEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pRegPreEncNew = pRegPreEncService.save(pRegPreEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pRegPreEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/regpreenc/updated")
    public ResponseEntity<?> update(@RequestBody PRegPreEnc pRegPreEnc) {
        // PRegPreEnc pRegPreEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pRegPreEnc == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pRegPreEnc != null) {
                response.put("ordendepago", pRegPreEncService.save(pRegPreEnc));
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
