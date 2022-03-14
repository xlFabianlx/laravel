package com.apirest.financiero.controllers;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CTipoCompContable;
import com.apirest.financiero.models.entity.CTipoCompContablePK;
import com.apirest.financiero.models.services.CTipoCompContableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CTipoCompContableController {

    @Autowired
    private CTipoCompContableService cTipoCompContableService;

    @GetMapping("/ctipo/comprobante/contable/list")
    public List<CTipoCompContable> findAll() {
        return cTipoCompContableService.findAll();
    }

    @GetMapping("/ctipo/comprobante/contable/pk")
    public ResponseEntity<?> show(@RequestBody CTipoCompContablePK cTipoCompContablePK) {
        CTipoCompContable CTipoCompContableActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CTipoCompContableActual = cTipoCompContableService.findByPK(cTipoCompContablePK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CTipoCompContableActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CTipoCompContable>(CTipoCompContableActual, HttpStatus.OK);
    }

    @PostMapping("/ctipo/comprobante/contable/new")
    public ResponseEntity<?> create(@RequestBody CTipoCompContable cTipoCompContable) {

        CTipoCompContable cTipoCompContableNew;
        Map<String, Object> response = new HashMap<>();

        try {
            cTipoCompContableNew = cTipoCompContableService.save(cTipoCompContable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El concepto de ingreso contable detalle ha sido creado con éxito!");
        response.put("response", cTipoCompContableNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/ctipo/comprobante/contable/updated")
    public ResponseEntity<?> update(@RequestBody CTipoCompContable cTipoCompContable) {
        CTipoCompContable cTipoCompContableActual = cTipoCompContableService.findByPK(cTipoCompContable.getCTipoCompContablePK()); 
        CTipoCompContable cTipoCompContableUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cTipoCompContableActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cTipoCompContableUpdated = cTipoCompContableService.save(cTipoCompContable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cTipoCompContableUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/ctipo/comprobante/contable/delete/{docCod}")
    public ResponseEntity<?> deleteUser(@PathVariable("docCod") String docCod) {
        Map<String, Object> response = new HashMap<>();
        try {
            CTipoCompContablePK pk = new CTipoCompContablePK();
            pk.setDocCod(docCod);
            cTipoCompContableService.delete(pk);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar El Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Usuario con id ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

}
