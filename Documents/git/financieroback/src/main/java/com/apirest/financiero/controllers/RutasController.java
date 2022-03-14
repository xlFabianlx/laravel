package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.Rutas;
import com.apirest.financiero.models.services.RutasService;

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
public class RutasController {
@Autowired
private RutasService rutasService;

@GetMapping("/rutas/list")
public List<Rutas> findAll (){
return rutasService.findAll();
}

@GetMapping("/roles/{id}")
public ResponseEntity<?> show(@PathVariable("id")Short id){
Rutas rutas;

Map<String, Object> response = new HashMap<>();

try {
rutas = rutasService.findById(id);
if (rutas == null) {
response.put("mensaje", "La ruta no existe");
return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
}
} catch (DataAccessException e) {
response.put("mensaje", "Error al realizar la consulta");
response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
}
return new ResponseEntity<>(rutas, HttpStatus.OK);
}
}
