package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.GSiaCatalogoCuenta;
import com.apirest.financiero.models.entity.GSiaCatalogoCuentaPK;
import com.apirest.financiero.models.services.GSiaCatalogoCuentaService;
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
public class GSiaCatalogoCuentaController {
    
    @Autowired
    private GSiaCatalogoCuentaService siacatcuentServ;
    
    @GetMapping("/siacatalogocta/list")
    public List<GSiaCatalogoCuenta> findAll(){
        return siacatcuentServ.findAll();
    }
    
    @GetMapping("/siacatalogocta/{empcod}/{anocod}/{siactacod}")
    public ResponseEntity<?> show(
        @PathVariable("empcod") Long empcod,
        @PathVariable("anocod") short anocod, 
        @PathVariable("siactacod") int siactacod, 
        GSiaCatalogoCuentaPK siacatalogoctaPK) {
        
        siacatalogoctaPK.setEmpCod(empcod);
        siacatalogoctaPK.setAnoCod(anocod);
        siacatalogoctaPK.setSiaCataCod(siactacod);
        
        

        GSiaCatalogoCuenta siacatalogocta;
        Map<String, Object> response = new HashMap<>();

        try {
            siacatalogocta = siacatcuentServ.findById(siacatalogoctaPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (siacatalogocta == null) {
            response.put("mensaje", "El parametro SIA catalogo de cuenta con el ID:".concat(siacatalogoctaPK.toString().concat(" no existe")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(siacatalogocta, HttpStatus.OK);
    }
    
    @PutMapping("/siacatalogocta/update")
    public ResponseEntity<?> update(@RequestBody GSiaCatalogoCuenta siacatalogocta) {
        GSiaCatalogoCuenta siacatalogoctaAct = siacatcuentServ.findById(siacatalogocta.getGSiaCatalogoCuentaPK());
        Map<String, Object> response = new HashMap<>();

        if (siacatalogoctaAct == null) {
            response.put("mensaje", "Error: no se puede editar, el parametro sia catalogo cuenta No existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        try {
            response.put("siacatalogocta", siacatcuentServ.save(siacatalogocta));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar  el parametro sia catalogo cuenta ");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El parametro sia catalogo cuenta  ha sido actualizado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/siacatalogocta/new")
    public ResponseEntity<?> create(@RequestBody GSiaCatalogoCuenta siacatalogocta) {
        Map<String, Object> response = new HashMap<>();

        try {
            response.put("siacatalogocta", siacatcuentServ.save(siacatalogocta));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El parametro sia catalogo cuenta ha sido creado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
