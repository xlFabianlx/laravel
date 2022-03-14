package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CEgresoOrdPago;
import com.apirest.financiero.models.entity.CEgresoOrdPagoPK;
import com.apirest.financiero.models.services.CEgresoOrdPagoService;

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
public class CEgresoOrdPagoController {

    @Autowired
    private CEgresoOrdPagoService cEgresoOrdPagoService;

    @GetMapping("/cegreso/orden/pago/list")
    public List<CEgresoOrdPago> findAll() {
        return cEgresoOrdPagoService.findAll();
    }

    @GetMapping("/cegreso/orden/pago/pk")
    public ResponseEntity<?> show(@RequestBody CEgresoOrdPagoPK CEgresoOrdPagoPK) {
        CEgresoOrdPago CEgresoOrdPagoActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CEgresoOrdPagoActual = cEgresoOrdPagoService.findByPK(CEgresoOrdPagoPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CEgresoOrdPagoActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CEgresoOrdPago>(CEgresoOrdPagoActual, HttpStatus.OK);
    }

    @PostMapping("/cegreso/orden/pago/new")
    public ResponseEntity<?> create(@RequestBody CEgresoOrdPago cEgresoOrdPago) {

        CEgresoOrdPago cEgresoOrdPagoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cEgresoOrdPagoNew = cEgresoOrdPagoService.save(cEgresoOrdPago);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cEgresoOrdPagoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cegreso/orden/pago/updated")
    public ResponseEntity<?> update(@RequestBody CEgresoOrdPago cEgresoOrdPago) {
        CEgresoOrdPago cEgresoOrdPagoActual = cEgresoOrdPagoService.findByPK(cEgresoOrdPago.getCEgresoOrdPagoPK()); 
        CEgresoOrdPago cEgresoOrdPagoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cEgresoOrdPagoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cEgresoOrdPagoUpdated = cEgresoOrdPagoService.save(cEgresoOrdPago);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cEgresoOrdPagoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
