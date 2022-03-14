package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NConcepto;
import com.apirest.financiero.models.services.NConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class NConceptoController{
    
    @Autowired
    private NConceptoService conceptoServ;

    @GetMapping("/concepto/list")
    public List<NConcepto> findAll() {
        return conceptoServ.findAll();
    }

    @GetMapping("/concepto/{id}")
    public ResponseEntity<?> show(@PathVariable("id") Short id){

        NConcepto concepto;

        Map<String, Object> response = new HashMap <>();

        try {
            concepto = conceptoServ.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if ( concepto == null ) {
            response.put("mensaje", "el concepto con el id: "+id.toString()+ " no existe");
            return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity <>(concepto, HttpStatus.OK);
    }

    @PutMapping("/concepto/update")
    public ResponseEntity<?> update (@RequestBody NConcepto concepto) {

        Map<String, Object> response = new HashMap <>();

        if (concepto != null) {
            try {
                response.put("cargo", conceptoServ.save(concepto));
            } catch (DataAccessException e) {
                response.put("mensaje", "error al realizar la actualizacion");
                response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        response.put("mensaje", "el concepto ha sido actualizado con éxito!");
        return new ResponseEntity <>(response, HttpStatus.ACCEPTED);
    }
}
