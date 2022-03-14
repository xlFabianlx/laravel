package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GTerceroPtal;
import com.apirest.financiero.models.services.GTerceroPtalService;

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

public class GTerceroPtalController {

    @Autowired
    private GTerceroPtalService gTerceroPtalService;

    @GetMapping("/gterceroptal")
    public List<GTerceroPtal> findAll(){
        return gTerceroPtalService.findAll();
    }

    @GetMapping("/gterceroptal/{id}")
    public GTerceroPtal findById(@PathVariable("id") Long id){
        return gTerceroPtalService.findById(id);
    }

    @GetMapping("/gterceroptal/codigo/{terCod}")
    public GTerceroPtal findByTerCod(@PathVariable("terCod") Long terCod){
        return gTerceroPtalService.findByTerCod(terCod);
    }

   @PostMapping("/gterceroptal/new")
   public ResponseEntity<?> create(@RequestBody GTerceroPtal gTerceroPtal){
    Map<String, Object> response = new HashMap<>();
    GTerceroPtal terceros = null;
    terceros = gTerceroPtalService.findById(gTerceroPtal.getTerCod());
    if (terceros == null){
        try {
            // response.put("TERCERO", gTerceroPtalService.save(gTerceroPtal));
            GTerceroPtal gTerceroPtalNew;
            gTerceroPtalNew = gTerceroPtalService.save(gTerceroPtal);
            response.put("mensaje", "Tercero creado con éxito");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            } 
    }else{
        response.put("mensaje", "El tercero ya existe!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.FORBIDDEN);

    }

}

   
   
    @PutMapping("/gterceroptal/update")
    public ResponseEntity<?> update(@RequestBody GTerceroPtal gTerceroPtal) {
        
        Map<String, Object> response = new HashMap<>();
        
        GTerceroPtal contribuyenteAct = gTerceroPtalService.findById(gTerceroPtal.getTerCod());

        if (contribuyenteAct == null) {
            response.put("mensaje", "Error: no se puede editar, el tercero no existe!");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        /* try { */
            response.put("gTerceroPtal", gTerceroPtalService.save(gTerceroPtal));
     /*    } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el tercero");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } */
        response.put("mensaje", "El tercero ha sido actualizado con éxito!");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


   @PutMapping("/gterceroptal/{id}")
   public ResponseEntity<?> update(@RequestBody GTerceroPtal gTerceroPtal, @PathVariable("id") Long id ){
    GTerceroPtal gTerceroPtalActual = gTerceroPtalService.findById(id);
    GTerceroPtal gTerceroPtalUpdated;

    Map<String, Object> response = new HashMap<>();

    if (gTerceroPtalActual == null) {
        response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
    }
    try {
        gTerceroPtalUpdated  = gTerceroPtalService.save(gTerceroPtal);
    } catch (DataAccessException e) {
        response.put("mensaje", "Error al actualizar el comprobante contable detalle");
        response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
    response.put("comprobcontdet", gTerceroPtalUpdated);
    return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
   }
}