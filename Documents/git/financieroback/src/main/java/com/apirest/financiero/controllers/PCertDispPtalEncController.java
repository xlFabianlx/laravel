package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PCertDispPtalEnc;
import com.apirest.financiero.models.entity.PCertDispPtalEncPK;
import com.apirest.financiero.models.services.PCertDispPtalEncService;
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
public class PCertDispPtalEncController {
    @Autowired
    private PCertDispPtalEncService pCertDispPtalEncService;


    @GetMapping("/certdispptalenc/list")
    public List<PCertDispPtalEnc> findAll() {
        return pCertDispPtalEncService.findAll();
    }


    @GetMapping("/certdispptalenc/pk")
    public ResponseEntity<?> show(@RequestBody PCertDispPtalEncPK pCertDispPtalEncPK) {
        PCertDispPtalEnc pCertDispPtalEnc;
        Map<String, Object> response = new HashMap<>();

        try {
            pCertDispPtalEnc = pCertDispPtalEncService.findById(pCertDispPtalEncPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pCertDispPtalEnc == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PCertDispPtalEnc>(pCertDispPtalEnc, HttpStatus.OK);
    }


    @PostMapping("/certdispptalenc/new")
    public ResponseEntity<?> create(@RequestBody PCertDispPtalEnc pCertDispPtalEnc) {

        PCertDispPtalEnc pCertDispPtalEncNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pCertDispPtalEncNew = pCertDispPtalEncService.save(pCertDispPtalEnc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pCertDispPtalEncNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/certdispptalenc/updated")
    public ResponseEntity<?> update(@RequestBody PCertDispPtalEnc pCertDispPtalEnc) {
        PCertDispPtalEnc pCertDispPtalEncActual = pCertDispPtalEncService.findById(pCertDispPtalEnc.getPCertDispPtalEncPK());
        PCertDispPtalEnc pCertDispPtalEncUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pCertDispPtalEncActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pCertDispPtalEncActual.setScdpCod(pCertDispPtalEnc.getScdpCod());
            pCertDispPtalEncActual.setCdpEst(pCertDispPtalEnc.getCdpEst());
            pCertDispPtalEncActual.setCdpCsaAnu(pCertDispPtalEnc.getCdpCsaAnu());
            pCertDispPtalEncActual.setCdpFecAnu(pCertDispPtalEnc.getCdpFecAnu());
            pCertDispPtalEncActual.setCdpHorAnu(pCertDispPtalEnc.getCdpHorAnu());
            pCertDispPtalEncActual.setCdpUsuAnu(pCertDispPtalEnc.getCdpUsuAnu());
            pCertDispPtalEncActual.setCtaCod(pCertDispPtalEnc.getCtaCod());
            pCertDispPtalEncActual.setRegCta(pCertDispPtalEnc.getRegCta());
            pCertDispPtalEncActual.setRegCtaD(pCertDispPtalEnc.getRegCtaD());
            pCertDispPtalEncActual.setCdRest(pCertDispPtalEnc.getCdRest());
            pCertDispPtalEncActual.setCdpCpt(pCertDispPtalEnc.getCdpCpt());
            pCertDispPtalEncActual.setCdpFec(pCertDispPtalEnc.getCdpFec());
            pCertDispPtalEncActual.setCdpHor(pCertDispPtalEnc.getCdpHor());
            pCertDispPtalEncActual.setCdpUsu(pCertDispPtalEnc.getCdpUsu());
            pCertDispPtalEncActual.setCdpVlr(pCertDispPtalEnc.getCdpVlr());
            pCertDispPtalEncActual.setCdpVlrQueda(pCertDispPtalEnc.getCdpVlrQueda());
            pCertDispPtalEncActual.setCdpComp(pCertDispPtalEnc.getCdpComp());
            pCertDispPtalEncActual.setCdpLibr(pCertDispPtalEnc.getCdpLibr());
            pCertDispPtalEncActual.setEntCertificado(pCertDispPtalEnc.getEntCertificado());
            pCertDispPtalEncActual.setCdpCptLib(pCertDispPtalEnc.getCdpCptLib());
            pCertDispPtalEncActual.setCdpFecLib(pCertDispPtalEnc.getCdpFecLib());
            pCertDispPtalEncActual.setCdpFecVen(pCertDispPtalEnc.getCdpFecVen());
            pCertDispPtalEncActual.setCdpFir(pCertDispPtalEnc.getCdpFir());
            pCertDispPtalEncActual.setCdpAltCod(pCertDispPtalEnc.getCdpAltCod());
            pCertDispPtalEncActual.setCdpAutEst(pCertDispPtalEnc.isCdpAutEst());
            pCertDispPtalEncUpdated = pCertDispPtalEncService.save(pCertDispPtalEncActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pCertDispPtalEncUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
