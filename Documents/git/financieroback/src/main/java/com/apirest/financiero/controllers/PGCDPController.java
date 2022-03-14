package com.apirest.financiero.controllers;
import com.apirest.financiero.models.entity.PgCdp;
import com.apirest.financiero.models.services.PGCDPService;
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

public class PGCDPController {
    @Autowired
    private PGCDPService pGCDPService;

    @GetMapping("/cdp/list")
    public List<PgCdp> findAllDesc() {
        return pGCDPService.findAllDesc();
    }

    @PostMapping("/cdp/new/{anoCod}")
    public ResponseEntity<?> create(@RequestBody PgCdp pgCdp,
    @PathVariable("anoCod") short anoCod) {

        PgCdp pgCdpNew;
        Map<String, Object> response = new HashMap<>();

        try {
            long cod = pGCDPService.getConsecutivo(anoCod);
            pgCdp.getPgCdpPK().setCdpCod(cod);
            pgCdpNew = pGCDPService.save(pgCdp);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "¡El CDP ha sido creada con éxito!");
        response.put("cdp", pgCdpNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/cdp/cambioestado")
    public ResponseEntity<?> anular(@RequestBody PgCdp pgCdp){
        Map<String, Object> response = new HashMap<>();
        try {
            pgCdp.setCdpEst("Anulado");
            response.put("mensaje", pGCDPService.save(pgCdp));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el CDP");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     response.put("mensaje", "El CDP ha sido anulada con éxito!");
     return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}
