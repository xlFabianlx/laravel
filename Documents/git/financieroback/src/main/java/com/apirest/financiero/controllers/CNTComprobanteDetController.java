package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CNTComprobanteDet;
import com.apirest.financiero.models.entity.CNTComprobanteDetPK;
import com.apirest.financiero.models.services.CCNTComprobanteDetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CNTComprobanteDetController {
    
    @Autowired
    private CCNTComprobanteDetService cCNTComprobanteDetService;

    @GetMapping("/cntcomp/comprobante/contable/list")public List<CNTComprobanteDet> findAll(){
        return cCNTComprobanteDetService.findAll();
    }

    @GetMapping("/cntcomp/comprobante/contable/pk")
    public ResponseEntity<?> show(@RequestBody CNTComprobanteDetPK cNTComprobanteDetPK) {
        CNTComprobanteDet CNTComprobanteDetActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CNTComprobanteDetActual = cCNTComprobanteDetService.findByPK(cNTComprobanteDetPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CNTComprobanteDetActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CNTComprobanteDet>(CNTComprobanteDetActual, HttpStatus.OK);
    }
}
