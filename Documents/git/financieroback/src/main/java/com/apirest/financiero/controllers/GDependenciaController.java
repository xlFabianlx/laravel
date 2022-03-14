package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GDependencia;
import com.apirest.financiero.models.entity.GDependenciaPK;
import com.apirest.financiero.models.services.GDependenciaService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class GDependenciaController {

    @Autowired
    private GDependenciaService gDependenciaService;

    @GetMapping("/dependecia/list")
    public List<GDependencia> findAll(){
        return gDependenciaService.findAll();
    }

    @GetMapping("/dependecia/id")
    public GDependencia findById(@RequestBody GDependenciaPK gDependenciaPK){
        return gDependenciaService.findById(gDependenciaPK);
    }

    
    

/*     @PostMapping("/dependecia/new")
    public ResponseEntity<?> create(@RequestBody GDependencia gDependencia){
        GDependencia gDependenciaNew;
        
        Map<String, Object> response = new HashMap<>();
        try {
            gDependenciaNew = gDependenciaService.save(gDependencia);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El comprobante contable detalle ha sido creado con éxito!");
        response.put("comprobanteContable", gDependenciaNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
        
    } */

    @PostMapping("/dependecia/new")
    public ResponseEntity<?> create(@RequestBody GDependencia gDependencia){
        GDependencia gDependenciaNew;
        Map<String, Object> response = new HashMap<>();
        try {
            Long consecutivo = gDependenciaService.findConsecutivo();
        
            if (consecutivo == null){
                consecutivo = (long)1;
            
            }else{
                consecutivo = consecutivo + 1;
            
            }
            gDependencia.getGDependenciaPK().setDepCod(consecutivo);
            gDependenciaNew = gDependenciaService.save(gDependencia); 
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El proyecto ha sido creado con éxito!");
        response.put("proyecto", gDependenciaNew);  
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/dependecia/update")
    public ResponseEntity<?> update(@RequestBody GDependencia gDependencia){
        GDependencia gDependenciaActual = gDependenciaService.findById(gDependencia.getGDependenciaPK());
        GDependencia gDependenciaUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gDependenciaActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gDependenciaUpdated  = gDependenciaService.save(gDependencia);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("comprobcontdet", gDependenciaUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/dependencia/delete/{empCod}/{depCod}")
    public ResponseEntity<?> deleteUser(@PathVariable("empCod") String empCod, @PathVariable("depCod") long depCod) {
        Map<String, Object> response = new HashMap<>();
        try {
            GDependenciaPK pk = new GDependenciaPK();
            pk.setDepCod(depCod);
            pk.setEmpCod(empCod);
            gDependenciaService.delete(pk);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar El Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El Usuario con id ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}