package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CCuentaBancaria;
import com.apirest.financiero.models.entity.CCuentaBancariaPK;
import com.apirest.financiero.models.services.CCuentaBancariaService;

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
@CrossOrigin({ "*" })
@RequestMapping("/api/v1")
public class CCuentaBancariaController {

    @Autowired
    private CCuentaBancariaService cCuentaBancariaService;

    @GetMapping("/ccuentabancaria/list")
    public List<CCuentaBancaria> findAll() {
        return cCuentaBancariaService.findAll();
    }

    @GetMapping("/ccuentabancaria/pk")
    public ResponseEntity<?> show(@RequestBody CCuentaBancariaPK cCuentaBancariaPK) {
        CCuentaBancaria cCuentaBancariaActual;
        Map<String, Object> response = new HashMap<>();

        try {
            cCuentaBancariaActual = cCuentaBancariaService.findByPK(cCuentaBancariaPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cCuentaBancariaActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CCuentaBancaria>(cCuentaBancariaActual, HttpStatus.OK);
    }

    @PostMapping("/ccuentabancaria/new")
    public ResponseEntity<?> create(@RequestBody CCuentaBancaria cCuentaBancaria) {

        CCuentaBancaria cCuentaBancariaNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cCuentaBancariaNew = cCuentaBancariaService.save(cCuentaBancaria);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("cCuentaBancariaNew", cCuentaBancariaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/ccuentabancaria/updated")
    public ResponseEntity<?> update(@RequestBody CCuentaBancaria cCuentaBancaria) {
        CCuentaBancaria cCuentaBancariaActual = cCuentaBancariaService.findByPK(cCuentaBancaria.getCCuentaBancariaPK());
        CCuentaBancaria cCuentaBancariaUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cCuentaBancariaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cCuentaBancariaUpdated = cCuentaBancariaService.save(cCuentaBancaria);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("cCuentaBancaria", cCuentaBancariaUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
