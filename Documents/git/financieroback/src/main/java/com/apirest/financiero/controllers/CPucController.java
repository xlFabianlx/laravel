package com.apirest.financiero.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CPuc;
import com.apirest.financiero.models.entity.CPucPK;
import com.apirest.financiero.models.services.CPucService;

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
public class CPucController {

    @Autowired
    private CPucService cPucService; 

    @GetMapping("/cpuc/codigo/{codigo}")
    public Boolean ValidarNiveles(@PathVariable("codigo") String codigo) {
        return cPucService.findIfExist(codigo);
    }

    @GetMapping("/cpuc/list")
    public List<CPuc> findAll() {
        return cPucService.findAll();
    }

    @GetMapping("/cpuc/list/order")
    public List<CPuc> findByCueCod() {
        return cPucService.findByCueCod();
    }

    @GetMapping("/cpuc/list/principal")
    public List<CPuc> findPricipal() {
        return cPucService.findPrincipal();
    }

    @GetMapping("/cpuc/list/codigo/{cuecod}")
    public List<CPuc> findByFilter(@PathVariable("cuecod") String cuecod) {
        List<CPuc> puc = cPucService.findByFilter(cuecod);
        puc.remove(0);
        return puc;
    }

    @GetMapping("/cpuc/pk")
    public ResponseEntity<?> show(@RequestBody CPucPK cPucPK) {
        CPuc CPucActual;
        Map<String, Object> response = new HashMap<>();

        try {
            CPucActual = cPucService.findByPK(cPucPK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta");
            response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (CPucActual == null) {
            response.put("mensaje", "El comprobante contable encabezado no existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CPuc>(CPucActual, HttpStatus.OK);
    }

    @PostMapping("/cpuc/new")
    public ResponseEntity<?> save(@RequestBody CPuc cPuc) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("cpuc", cPucService.save(cPuc));
            response.put("mensaje", "se ha creado el libro contable!");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al crear el libro contable!");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/cpuc/updated")
    public ResponseEntity<?> update(@RequestBody CPuc cPuc) {
        CPuc cPucActual = cPucService.findByPK(cPuc.getCPucPK()); 
        CPuc cPucUpdated;

        Map<String, Object> response = new HashMap<>();

        if (cPucActual == null) {
            response.put("mensaje", "Error: no se puede editar, el comprobanteContDetActual No existe");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            cPucUpdated = cPucService.save(cPuc);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el comprobante contable detalle");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El comprobante contable detalle ha sido actualizado con éxito!");
        response.put("response", cPucUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
}



class Info {

    private CPuc data;
    private List<CPuc> children;

    public CPuc getData() {
        return data;
    }

    public void setData(CPuc data) {
        this.data = data;
    }

    public List<CPuc> getChildren() {
        return children;
    }

    public void setChildren(List<CPuc> children) {
        this.children = children;
    }
    
}