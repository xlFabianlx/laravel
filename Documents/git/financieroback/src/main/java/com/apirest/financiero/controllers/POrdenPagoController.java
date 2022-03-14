package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.POrdenPago;
import com.apirest.financiero.models.entity.POrdenPagoPK;
import com.apirest.financiero.models.services.POrdenPagoService;
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
public class POrdenPagoController {
    @Autowired
    private POrdenPagoService pOrdenPagoService;

    @GetMapping("/ordenespago/list")
    public List<POrdenPago> findAll() {
        return pOrdenPagoService.findAll();
    }

    @GetMapping("/ordenespago/cuentasxpagar")
    public List<POrdenPago> finOrdenesPagoWithoutEgreso() { return pOrdenPagoService.finOrdenesPagoWithoutEgreso(); }

    @GetMapping("/ordenespago/pk")
    public ResponseEntity<?> show(@RequestBody POrdenPagoPK pOrdenPagoPK) {
        POrdenPago pOrdenPago;
        Map<String, Object> response = new HashMap<>();

        try {
            pOrdenPago = pOrdenPagoService.findById(pOrdenPagoPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pOrdenPago == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<POrdenPago>(pOrdenPago, HttpStatus.OK);
    }


    @PostMapping("/ordenespago/new")
    public ResponseEntity<?> create(@RequestBody POrdenPago pOrdenPago) {

        POrdenPago pOrdenPagoNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pOrdenPagoNew = pOrdenPagoService.save(pOrdenPago);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pOrdenPagoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/ordenespago/updated")
    public ResponseEntity<?> update(@RequestBody POrdenPago pOrdenPago) {
        // POrdenPago pOrdenPagoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pOrdenPago == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            if(pOrdenPago != null) {
                response.put("ordendepago", pOrdenPagoService.save(pOrdenPago));
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
