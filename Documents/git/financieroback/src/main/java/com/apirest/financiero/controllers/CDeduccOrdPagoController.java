package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CDeduccOrdPago;
import com.apirest.financiero.models.entity.CDeduccOrdPagoPK;
import com.apirest.financiero.models.services.CDeduccOrdPagoService;

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
public class CDeduccOrdPagoController {

    @Autowired
    private CDeduccOrdPagoService cDeduccOrdPagoService;

    @GetMapping("/deduccion/ord/pago/list")
    public List<CDeduccOrdPago> findAll() {
        return cDeduccOrdPagoService.findAll();
    }

    @GetMapping("/deduccion/ord/pago/pk")
    public ResponseEntity<?> show(@RequestBody CDeduccOrdPagoPK cDeduccOrdPagoPK) {
        CDeduccOrdPago CDeduccOrdPagoActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CDeduccOrdPagoActual = cDeduccOrdPagoService.findByPK(cDeduccOrdPagoPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CDeduccOrdPagoActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CDeduccOrdPago>(CDeduccOrdPagoActual, HttpStatus.OK);
    }

    @PostMapping("/deduccion/ord/pago/new")
    public ResponseEntity<?> create(@RequestBody CDeduccOrdPago cDeduccOrdPago) {

        CDeduccOrdPago cDeduccOrdPagoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cDeduccOrdPagoNew = cDeduccOrdPagoService.save(cDeduccOrdPago);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cDeduccOrdPagoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/deduccion/ord/pago/updated")
    public ResponseEntity<?> update(@RequestBody CDeduccOrdPago cDeduccOrdPago) {
        CDeduccOrdPago cDeduccOrdPagoActual = cDeduccOrdPagoService.findByPK(cDeduccOrdPago.getCDeduccOrdPagoPK());
        CDeduccOrdPago cDeduccOrdPagoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cDeduccOrdPagoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cDeduccOrdPagoUpdated = cDeduccOrdPagoService.save(cDeduccOrdPago);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cDeduccOrdPagoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
