package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.apirest.financiero.models.services.CCNTComprobantesService;
import com.apirest.financiero.models.entity.CNTComprobantes;
import com.apirest.financiero.models.entity.CNTComprobantesPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CNTComprobantesController {
    
    @Autowired
    private CCNTComprobantesService cCNTComprobantesService;

    @GetMapping("/cntcomp/comprobantes/contables/list")
    public List<CNTComprobantes> findAll() {
        return cCNTComprobantesService.findAll();
    }

    @GetMapping("/cntcomp/comprobantes/contables/id")
    public CNTComprobantes findById(@RequestBody CNTComprobantesPK cNTComprobantesPK){
        return cCNTComprobantesService.findById(cNTComprobantesPK);
    }

   

    // @GetMapping("/cntcomp/comprobantes/contables/{compCod}")
    // public List<CNTComprobantesPK> findByComprobantes(
    //     @PathVariable("compCod")Long compCod
    // ){
    //     return cCNTComprobantesService.findByComprobantes(compCod);
    // }

    

    @PostMapping("/cntcomp/comprobantes/contables/new")
    public ResponseEntity<?> create(@RequestBody CNTComprobantes cNTComprobantes){
        CNTComprobantes cNTComprobantesNew;

        Map<String, Object> response = new HashMap<>();
        try {
            Long consecutivo = cCNTComprobantesService.findConsecutivo();
        
            if (consecutivo == null){
                consecutivo = (long)1; 
            
            }else{
                consecutivo = consecutivo + 1;
            
            }
            cNTComprobantes.getCNTComprobantesPK().setCompCod(consecutivo);
            cNTComprobantesNew = cCNTComprobantesService.save(cNTComprobantes); 
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El proyecto ha sido creado con éxito!");
        response.put("proyecto", cNTComprobantesNew);  
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
}

}