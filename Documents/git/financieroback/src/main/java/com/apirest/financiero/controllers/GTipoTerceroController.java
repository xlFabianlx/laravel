package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.GTipoTercero;
import com.apirest.financiero.models.services.GTipoTerceroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")

public class GTipoTerceroController {
    @Autowired
    private GTipoTerceroService service;
    
    @GetMapping("/gtipotercero")
    public List<GTipoTercero> findAll(){
        return service.findAll();
    }
}

