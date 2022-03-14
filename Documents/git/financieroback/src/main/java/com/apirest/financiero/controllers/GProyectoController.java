package com.apirest.financiero.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GProyecto;
import com.apirest.financiero.models.entity.GProyectoPK;
import com.apirest.financiero.models.services.GProyectoService;

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
public class GProyectoController {

    @Autowired
    private GProyectoService gProyectoService;

    @GetMapping("/gproyecto/list")
    public List<GProyecto> findAll(){
        return gProyectoService.findAll();
    }

    @GetMapping("/gproyecto/listAll")
    public List<GProyecto> findAllProyecto(){
        return gProyectoService.findAllProyecto();
    }

    @GetMapping("/gproyecto/id")
    public GProyecto findById(@RequestBody GProyectoPK gProyectopPk){
        return gProyectoService.findById(gProyectopPk);
    }

    @PostMapping("/gproyecto/new")
    public ResponseEntity<?> create(@RequestBody GProyecto gProyecto){
        GProyecto gProyectoNew;

        Map<String, Object> response = new HashMap<>();
        try {
            Long consecutivo = gProyectoService.findConsecutivo();
        
            if (consecutivo == null){
                consecutivo = (long)1;
            
            }else{
                consecutivo = consecutivo + 1;
            
            }
            gProyecto.getGProyectoPK().setProyCod(consecutivo);
            gProyectoNew = gProyectoService.save(gProyecto); 
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El proyecto ha sido creado con éxito!");
        response.put("proyecto", gProyectoNew);  
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    
    @PutMapping("/gproyecto/update")
    public ResponseEntity<?> updated(@RequestBody GProyecto gProyecto){
        Map<String, Object> response = new HashMap<>();
        GProyecto actual = null;
        try {
            actual = gProyectoService.findProyectoId(gProyecto.getGProyectoPK().getProyCod());
            if (actual != null){
                actual.setAvanceFin(gProyecto.getAvanceFin());
                actual.setAvanceFis(gProyecto.getAvanceFis());
                actual.setProyNombre(gProyecto.getProyNombre());
                actual.setProyDetalle(gProyecto.getProyDetalle());
                actual.setInstpart(gProyecto.getInstpart());
                response.put("proyecto", gProyectoService.save(actual));
            }
            response.put("mensaje", "proyecto actualizado!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}