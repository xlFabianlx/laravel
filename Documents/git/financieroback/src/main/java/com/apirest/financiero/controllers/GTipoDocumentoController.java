package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.GTipoDocumento;
import com.apirest.financiero.models.services.GTipoDocumentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")

public class GTipoDocumentoController {
    @Autowired
    private GTipoDocumentoService service;
    
    @GetMapping("/gtipodocumento")
    public List<GTipoDocumento> findAll(){
        return service.findAll();
    }
}
