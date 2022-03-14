package com.apirest.financiero.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.GBanco;
import com.apirest.financiero.models.entity.GBancoPK;
import com.apirest.financiero.models.services.GBancoService;

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
@RequestMapping("/api/v1/")
public class GBancoController {

    @Autowired
    private GBancoService gBancoService;


    @GetMapping("gbanco/list")
    public List<GBanco> findAll(){
        return gBancoService.findAll();
    }

    @GetMapping("gbanco/id")
    public GBanco findById(@RequestBody GBancoPK gBancoPK ){
        return gBancoService.findById(gBancoPK);
    }

    @PostMapping("gbanco/new")
    public ResponseEntity<?> createGanio(@RequestBody GBanco gBanco){
        GBanco gBancoNew;
        Map<String, Object> response = new HashMap<>();
        try {
            gBancoNew = gBancoService.save(gBanco);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El Banco ha sido creado con éxito!");
        response.put("comprobanteContable", gBancoNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("gbanco/updated")
    public ResponseEntity<?> update(@RequestBody GBanco gBanco){
        GBanco gBancoActual = gBancoService.findById(gBanco.getGBancoPK());
        GBanco gBancoUpdated;

        Map<String, Object> response = new HashMap<>();

        if (gBancoActual == null) {
            response.put("mensaje", "Error: no se puede editar, el Banco No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            gBancoUpdated  = gBancoService.save(gBanco);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el Banco");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El banco ha sido actualizado con éxito!");
        response.put("comprobcontdet", gBancoUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/gbanco/delete/{empCod}/{banCod}")
    public ResponseEntity<?> deleteUser(@PathVariable("empCod") String empCod, @PathVariable("banCod") String banCod) {
        Map<String, Object> response = new HashMap<>();
        try {
            GBancoPK pk = new GBancoPK();
            pk.setBanCod(banCod);
            pk.setEmpCod(empCod);
            gBancoService.delete(pk);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el Usuario");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("¡mensaje", "El usuario con id ha sido eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
     
}