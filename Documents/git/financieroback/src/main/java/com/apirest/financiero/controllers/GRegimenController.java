package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.GRegimen;
import com.apirest.financiero.models.services.GRegimenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")

public class GRegimenController {
    @Autowired
    private GRegimenService service;
    
    @GetMapping("/gregimen")
    public List<GRegimen> findAll(){
        return service.findAll();
    }
}

