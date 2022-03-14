package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PGSolicitudCDP;
import com.apirest.financiero.models.services.PSolicitudCdpService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class PSolicitudCdpController {
    @Autowired
    private PSolicitudCdpService pSolicitudCdpService;

    @GetMapping("/solicitudcdp/list")
    public List<PGSolicitudCDP> findAllDesc() {
        return pSolicitudCdpService.findAllDesc();
    }

    @GetMapping("/solicitudcdp/anoCod/scdpCod/{anoCod}/{scdpCod}")
    public List<PGSolicitudCDP> findByAnoCod(@PathVariable("anoCod") short anoCod, @PathVariable("scdpCod") long scdpCod) {
      return pSolicitudCdpService.findByAnoCod(anoCod, scdpCod);
    }

    @GetMapping("/solicitudcdp/valores/anoCod/scdpCod/{anoCod}/{scdpCod}")
    public List<JSONObject> findValores(@PathVariable("anoCod") short anoCod, @PathVariable("scdpCod") long scdpCod) {
      return pSolicitudCdpService.findValores(anoCod, scdpCod);
    }

    @PostMapping("/solicitudcdp/new/{anoCod}")
    public ResponseEntity<?> create(@RequestBody PGSolicitudCDP pGSolicitudCDP,
    @PathVariable("anoCod") short anoCod) {

        PGSolicitudCDP pGSolicitudCDPNew;
        Map<String, Object> response = new HashMap<>();

        try {
            long cod = pSolicitudCdpService.getConsecutivo(anoCod);
            pGSolicitudCDP.getPGSolicitudCDPPK().setScdpCod(cod);
            pGSolicitudCDPNew = pSolicitudCdpService.save(pGSolicitudCDP);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "La solicitud de CDP ha sido creada con éxito!");
        response.put("solicitud", pGSolicitudCDPNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/solicitudcdp/updated")
    public ResponseEntity<?> update(@RequestBody PGSolicitudCDP pGSolicitudCDP){
        PGSolicitudCDP pGSolicitudCDPActual = pSolicitudCdpService.findById(pGSolicitudCDP.getPGSolicitudCDPPK());
        PGSolicitudCDP pGSolicitudCDPUpdated;

        Map<String, Object> response = new HashMap<>();
 
        if (pGSolicitudCDPActual == null) {
            response.put("mensaje", "Error: no se puede editar, la solicitud no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pGSolicitudCDPUpdated  = pSolicitudCdpService.save(pGSolicitudCDP);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar la solicitud");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La solicitud ha sido actualizado con éxito!");
        response.put("comprobcontdet", pGSolicitudCDPUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PutMapping("/solicitudcdp/cambioestado")
    public ResponseEntity<?> anular(@RequestBody PGSolicitudCDP pGSolicitudCDP){
        Map<String, Object> response = new HashMap<>();
        try {
            pGSolicitudCDP.setScdpEstado("anulado");
            response.put("mensaje", pSolicitudCdpService.save(pGSolicitudCDP));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar la solicitud");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
     response.put("mensaje", "La solicitud ha sido anulada con éxito!");
     return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/solicitudcdp/{vigencia}/{codigo}")
    public ResponseEntity<?> generarSolicitudCDP(
      @PathVariable("vigencia") String vigencia,
      @PathVariable("codigo") String codigo
    )
      throws Exception {
      String filename = "SOLICITUDCDP.pdf";
      HttpHeaders cabecera = new HttpHeaders();
      cabecera.add(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=\"" + filename + "\""
      );
      ResponseEntity<byte[]> response = new ResponseEntity<>(
        pSolicitudCdpService.exportSolicitudCDP(vigencia, codigo),
        cabecera,
        HttpStatus.OK
      );
      return response;
    } 


}
