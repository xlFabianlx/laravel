package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CComprobanteContEnc;
import com.apirest.financiero.models.services.CComprobanteContEncService;

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
public class CComprobanteContEncController {

    @Autowired
    private CComprobanteContEncService cComprobanteContEncService;

    @GetMapping("/comprobantecontableencabezado/list")
    public List<CComprobanteContEnc> findAll() {
        return cComprobanteContEncService.findAll();
    }


/*     @GetMapping("/comprobante/contable/encabezado/pk")
    public ResponseEntity<?> show(@RequestBody CComprobanteContEncPK cComprobanteContEncPK) {
        CComprobanteContEnc CComprobanteContEncActual;
        Map<String, Object> response = new HashMap<>();

        try {
            cComprobanteContEncActual = cComprobanteContEncService.findByPK(cComprobanteContEnc.getCComprobanteContEncPK());
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (cComprobanteContEncActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CComprobanteContEnc>(cComprobanteContEncActual, HttpStatus.OK);
    }
 */
    @PostMapping("/comprobantecontableencabezado/new")
    public ResponseEntity<?> create(@RequestBody CComprobanteContEnc cComprobanteContEnc) {

        CComprobanteContEnc CComprobanteContEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            CComprobanteContEncNew = cComprobanteContEncService.save(cComprobanteContEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", CComprobanteContEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/comprobantecontableencabezado/updated")
    public ResponseEntity<?> update(@RequestBody CComprobanteContEnc cComprobanteContEnc) {
        CComprobanteContEnc cComprobanteContEncActual = cComprobanteContEncService.findByPK(cComprobanteContEnc.getCComprobanteContEncPK());
        CComprobanteContEnc cComprobanteContEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cComprobanteContEncActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try { 
            cComprobanteContEncUpdated = cComprobanteContEncService.save(cComprobanteContEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", cComprobanteContEncUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
