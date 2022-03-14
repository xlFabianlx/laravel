package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.PFormatoRendicion;
import com.apirest.financiero.models.entity.PFormatoRendicionPK;
import com.apirest.financiero.models.services.PFormatoRendicionService;
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
public class PFormatoRendicionController {
    @Autowired
    private PFormatoRendicionService pFormatoRendicionService;



    @GetMapping("/formatoredireccion/list")
    public List<PFormatoRendicion> findAll() {
        return pFormatoRendicionService.findAll();
    }


    @GetMapping("/formatoredireccion/pk")
    public ResponseEntity<?> show(@RequestBody PFormatoRendicionPK pCertDispPtalEncPK) {
        PFormatoRendicion pFormatoRendicion;
        Map<String, Object> response = new HashMap<>();

        try {
            pFormatoRendicion = pFormatoRendicionService.findById(pCertDispPtalEncPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pFormatoRendicion == null) {
            response.put("mensaje", "El comprobante contable detalle  no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PFormatoRendicion>(pFormatoRendicion, HttpStatus.OK);
    }


    @PostMapping("/formatoredireccion/new")
    public ResponseEntity<?> create(@RequestBody PFormatoRendicion pFormatoRendicion) {

        PFormatoRendicion pFormatoRendicionNew;
        Map<String, Object> response = new HashMap<>();

        try {
            pFormatoRendicionNew = pFormatoRendicionService.save(pFormatoRendicion);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", pFormatoRendicionNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/formatoredireccion/updated")
    public ResponseEntity<?> update(@RequestBody PFormatoRendicion pFormatoRendicion) {
        PFormatoRendicion pFormatoRendicionActual = pFormatoRendicionService.findById(pFormatoRendicion.getPFormatoRendicionPK());
        PFormatoRendicion pFormatoRendicionUpdated;

        Map<String, Object> response = new HashMap<>();

        if (pFormatoRendicionActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            pFormatoRendicionActual.setForRenDes(pFormatoRendicion.getForRenDes());
            pFormatoRendicionActual.setForRenCod(pFormatoRendicion.getForRenCod());
            pFormatoRendicionActual.setForRenInd(pFormatoRendicion.getForRenInd());
            pFormatoRendicionUpdated = pFormatoRendicionService.save(pFormatoRendicionActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", pFormatoRendicionUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

}
