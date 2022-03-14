package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.Parametro;
import com.apirest.financiero.models.services.ParametroService;

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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class ParametroController {
    @Autowired
    private ParametroService parametroService;

    @GetMapping("/parametros/list")
    public List<Parametro> findAllParametro(){
        return parametroService.findAllParametro();
    }

    @GetMapping("/parametros/listFkGrupo")
    public Parametro findByIdFkGrupo(){
        return parametroService.findByIdFkGrupo();
    }

    @GetMapping("/parametros/listFkGrupo2")
    public List<Parametro> findByIdFkGrupo2(){
        return parametroService.findByIdFkGrupo2();
    }

    @PostMapping("/parametros/save")
    public ResponseEntity<?> save(@RequestBody Parametro parametro){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("parametro", parametroService.saveParametro(parametro));
            response.put("mensaje", "se ha creado el parametro!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/parametros/update")
    public ResponseEntity<?> editarParametro(@RequestBody Parametro parametro) {
        Map<String, Object> response = new HashMap<>();
        Parametro actual = null;

        try{
            actual = parametroService.findParametroId(parametro.getIdParametro());
            if (actual != null){
                actual.setCodigo(parametro.getCodigo());
                actual.setFecha(parametro.getFecha());
                actual.setNombre(parametro.getNombre());
                actual.setNombreCorto(parametro.getNombreCorto());
                actual.setValor(parametro.getValor());
                response.put("parametro", parametroService.saveParametro(actual));
            }
            response.put("mensaje", "parametro actualizado!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (DataAccessException e){
            response.put("mensaje", "error al actualizar!");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/parametro/delete/{idParametro}")
    public ResponseEntity<?> deleteUser(@PathVariable("idParametro") Integer idParametro) {
        Map<String, Object> response = new HashMap<>();
        try {
            parametroService.delete(idParametro);
            response.put("mensaje", "El parametro con id ha sido eliminado con éxito!");
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al Eliminar El Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }


}
