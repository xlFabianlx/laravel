package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CClase;
import com.apirest.financiero.models.entity.CClasePK;
import com.apirest.financiero.models.services.CClaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CClaseController {
    
    @Autowired
    private CClaseService cClaseService;

    @GetMapping("/clase/list")
    public List<CClase> findAll() {
        return cClaseService.findAll();
    }

    @GetMapping("/clase/list/idcla/{Idcla}")
    public List<CClase> findAll(@PathVariable("Idcla") short Idcla) {
        return cClaseService.findByIdcla(Idcla);
    }

    @PostMapping("/clase/id")
    public CClase findById(@RequestBody CClasePK cClasePK) {
        return cClaseService.findById(cClasePK);
    }

    @PostMapping("/clase/new")
    public ResponseEntity<?> createCClase(@RequestBody CClase cClase){
        CClase cClaseNew;
        Map<String, Object> response = new HashMap<>();
        try {
            cClaseNew = cClaseService.save(cClase);
        }catch ( DataAccessException e){
            response.put("mensaje", "Error al realizar la insercion");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "la clase se a creado con exito!");
        response.put("comprobanteContable", cClaseNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    } 
}
