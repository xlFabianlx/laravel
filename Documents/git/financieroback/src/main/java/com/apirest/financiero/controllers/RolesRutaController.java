package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.RolesRuta;
import com.apirest.financiero.models.services.RolesRutaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class RolesRutaController {
    @Autowired
    private RolesRutaService rolesService;
    
    @GetMapping("/rolesRuta/list")
    public List<RolesRuta> findAll (){
    return rolesService.findAll();
    }
    
    @GetMapping("/rolesRuta/{id}")
    public ResponseEntity<?> showbyId(@PathVariable("id")Short id){
    RolesRuta rolesRuta;
    
    Map<String, Object> response = new HashMap<>();
    
    try {
    rolesRuta = rolesService.findById(id);
    if (rolesRuta == null) {
    response.put("mensaje", "El roleRuta no existe");
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    } catch (DataAccessException e) {
    response.put("mensaje", "Error al realizar la consulta");
    response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(rolesRuta, HttpStatus.OK);
    }
    
    
}
