package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CComprobanteContDet;
import com.apirest.financiero.models.entity.CComprobanteContDetPK;
import com.apirest.financiero.models.services.CompranteContDetService;

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
public class ComprobanteContDetController {

    @Autowired
    private CompranteContDetService comprobantContDetServ;

    @GetMapping("/comprobante/contable/detalle/list")
    public List<CComprobanteContDet> findAll() {
        return comprobantContDetServ.findAll();
    }

    @PostMapping("/comprobante/contable/detalle/pk")
    public ResponseEntity<?> show(@RequestBody CComprobanteContDetPK comprobanteContDetPK) {
        CComprobanteContDet comprobanteContDet;
        Map<String, Object> response = new HashMap<>();

        try {
            comprobanteContDet = comprobantContDetServ.findById(comprobanteContDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (comprobanteContDet == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CComprobanteContDet>(comprobanteContDet, HttpStatus.OK);
    }

    @PostMapping("/comprobante/contable/detalle/new")
    public ResponseEntity<?> create(@RequestBody CComprobanteContDet comprobanteContDet) {

        CComprobanteContDet comprobanteContDetNew;
        Map<String, Object> response = new HashMap<>();

        try {
            comprobanteContDetNew = comprobantContDetServ.save(comprobanteContDet);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", comprobanteContDetNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/comprobante/contable/detalle/updated")
    public ResponseEntity<?> update(@RequestBody CComprobanteContDet comprobContDet) {
        CComprobanteContDet comprobContDetActual = comprobantContDetServ.findById(comprobContDet.getCComprobanteContDetPK());
        CComprobanteContDet comprobContDetUpdated;

        Map<String, Object> response = new HashMap<>();

        if (comprobContDetActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            comprobContDetUpdated = comprobantContDetServ.save(comprobContDetActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", comprobContDetUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
}
