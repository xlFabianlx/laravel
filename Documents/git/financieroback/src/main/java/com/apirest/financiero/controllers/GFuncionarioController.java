package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GFuncionario;
import com.apirest.financiero.models.services.GFuncionarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class GFuncionarioController {

    @Autowired
    private GFuncionarioService gFuncionarioService;

    @GetMapping("/gfuncionario/list")
    public List<GFuncionario> findAll(){
        return gFuncionarioService.findAll();
    }

    @GetMapping("/gfuncionario/{id}")
    public GFuncionario findById(@PathVariable("id") String id){
        return gFuncionarioService.findById(id);
    }
    
    @PostMapping("/gfuncionario/new")
    public ResponseEntity<?> create(@RequestBody GFuncionario gFuncionario){
        GFuncionario gFuncionarioNew;

        Map<String, Object> response = new HashMap<>();
        try {
            gFuncionarioNew = gFuncionarioService.save(gFuncionario);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gFuncionarioNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/gfuncionario/{id}")
    public ResponseEntity<?> update(@RequestBody GFuncionario gFuncionario, @PathVariable("id") String id){
        GFuncionario gFuncionarioActual = gFuncionarioService.findById(id);
        GFuncionario gFuncionarioUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gFuncionarioActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gFuncionarioUpdated  = gFuncionarioService.save(gFuncionario);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gFuncionarioUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}