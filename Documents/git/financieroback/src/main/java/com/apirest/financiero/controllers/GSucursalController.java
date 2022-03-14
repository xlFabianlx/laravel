package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GSucursal;
import com.apirest.financiero.models.entity.GSucursalPK;
import com.apirest.financiero.models.services.GSucursalService;

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
public class GSucursalController {

    @Autowired 
    private GSucursalService gSucursalService;

    @GetMapping("/gsucursal/list")
    public List<GSucursal> findAll(){
        return gSucursalService.findAll();
    }

    @GetMapping("/gsucursal/id")
    public GSucursal findById(@RequestBody GSucursalPK gSucursalpPk){
        return gSucursalService.findById(gSucursalpPk);
    }
    
    @PostMapping("/gsucursal/new")
    public ResponseEntity<?> create( @RequestBody GSucursal gSucursal){
        GSucursal gSucursalNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gSucursalNew = gSucursalService.save(gSucursal);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gSucursalNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gsucursal/updated")
    public ResponseEntity<?> update(@RequestBody GSucursal gSucursal){
        GSucursal gSucursalActual = gSucursalService.findById(gSucursal.getGSucursalPK());
        GSucursal gSucursalUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gSucursalActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gSucursalUpdated  = gSucursalService.save(gSucursal);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gSucursalUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}