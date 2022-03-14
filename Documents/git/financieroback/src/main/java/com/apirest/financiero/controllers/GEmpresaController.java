package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GEmpresa;
import com.apirest.financiero.models.services.GEmpresaService;

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
public class GEmpresaController {

    @Autowired
    private GEmpresaService gEmpresaService;


    @GetMapping("/gempresa/list")
    public List<GEmpresa> findAll(){
        return gEmpresaService.findAll();
    }

    @GetMapping("/gempresa/{id}")
    public GEmpresa findById(@PathVariable("id") Long id){
        return gEmpresaService.findById(id);
    }

    @PostMapping("/gempresa/new")
    public ResponseEntity<?> create(@RequestBody GEmpresa gEmpresa){
        GEmpresa gEmpresaNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gEmpresaNew = gEmpresaService.save(gEmpresa);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gEmpresaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gempresa/update")
    public ResponseEntity<?> editarParametro(@RequestBody GEmpresa gEmpresa) {
        Map<String, Object> response = new HashMap<>();
        GEmpresa actual = null;

        try{
            actual = gEmpresaService.findById(gEmpresa.getEmpCod());

            if (actual != null){
                actual.setEmpDir(gEmpresa.getEmpDir());
                actual.setEmpMail(gEmpresa.getEmpMail());
                actual.setEmpNit(gEmpresa.getEmpNit());
                actual.setEmpNom(gEmpresa.getEmpNom());
                actual.setEmpTel1(gEmpresa.getEmpTel1());
                actual.setEmpTel2(gEmpresa.getEmpTel2());
                actual.setEmpWeb(gEmpresa.getEmpWeb());
                response.put("empresa", gEmpresaService.save(actual)); 
            }
            response.put("mensaje", "Empresa actualizada!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/gempresa/update/estado")
    public ResponseEntity<?> updateEstado(@RequestBody GEmpresa gEmpresa) {
        Map<String, Object> response = new HashMap<>();
        GEmpresa actual = null;
        Boolean activo = Boolean.valueOf(true);
        Boolean inactivo = Boolean.valueOf(false);
        try {
            actual = gEmpresaService.findById(gEmpresa.getEmpCod());
            if (actual != null) {                
                if (gEmpresa.getEmpEstado().booleanValue() == true) {
                    gEmpresa.setEmpEstado(inactivo);
                    response.put("Empresa", gEmpresaService.save(gEmpresa));
                } else {
                    gEmpresa.setEmpEstado(activo);
                    response.put("Empresa", gEmpresaService.save(gEmpresa));
                } 
            }
            response.put("mensaje", "se ha cambiado el estado!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
/* 
    @PutMapping("/gempresa/{id}")
    public ResponseEntity<?> update(@RequestBody GEmpresa gEmpresa, @PathVariable("id") Long id){
        GEmpresa gEmpresaActual = gEmpresaService.findById(id);
        GEmpresa gEmpresaUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gEmpresaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gEmpresaUpdated  = gEmpresaService.save(gEmpresa);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gEmpresaUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    } */


    @DeleteMapping("/gempresa/delete/{empCod}")
    public ResponseEntity<?> deleteUser(@PathVariable("empCod") Long empCod) {
        Map<String, Object> response = new HashMap<>();
        try {
            gEmpresaService.delete(empCod);
            response.put("mensaje", "¡La empresa con el id ha sido eliminada con éxito!");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar la Empresa");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }



}