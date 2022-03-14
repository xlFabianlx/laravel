package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.GSiaCompromiso;
import com.apirest.financiero.models.entity.GSiaCompromisoPK;
import com.apirest.financiero.models.services.GSiaCompromisoService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class GSiaCompromisoController {
    @Autowired
    private GSiaCompromisoService siacompServ;
    
    @GetMapping("/siacompromiso/list")
    private List<GSiaCompromiso> findAll() {
        return siacompServ.findAll();
    }
    
    @GetMapping("/siacompromiso/{empcod}/{anocod}/{siaresper}/{siarescod}")
    private ResponseEntity<?> show(
        @PathVariable String empcod, 
        @PathVariable short anocod, 
        @PathVariable short siaresper,
        @PathVariable Long siarescod, 
        GSiaCompromisoPK siaCompromisoPk){
        
        siaCompromisoPk.setEmpCod(empcod);
        siaCompromisoPk.setAnoCod(anocod);
        siaCompromisoPk.setSiaResPer(siaresper);
        siaCompromisoPk.setSiaResCod(siarescod);
        
        GSiaCompromiso siaCompromiso;
        Map<String, Object> response = new HashMap<>();

        try {
            siaCompromiso = siacompServ.findById(siaCompromisoPk);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (siaCompromiso == null) {
            response.put("mensaje", "El parametro SIA compromiso con el ID: "+siaCompromisoPk.getSiaResCod()+" no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(siaCompromiso, HttpStatus.OK);
    }
    
    @PutMapping("/siacompromiso/update")
    public ResponseEntity<?> update(@RequestBody GSiaCompromiso siacompromiso) {
        GSiaCompromiso sicompromisoAct = siacompServ.findById(siacompromiso.getGSiaCompromisoPK());
        Map<String, Object> response = new HashMap<>();

        if (sicompromisoAct == null) {
            response.put("mensaje", "Error: no se puede editar, el parametro sia catalogo cuenta No existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            response.put("siacompromiso", siacompServ.save(siacompromiso));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar  el parametro sia compromiso");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El parametro sia compromiso ha sido actualizado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
     
    @PostMapping("/siacompromiso/new")
    public ResponseEntity<?> create(@RequestBody GSiaCompromiso siacompromiso) {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("siacompromiso", siacompServ.save(siacompromiso));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El parametro sia compromiso ha sido creado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
}
