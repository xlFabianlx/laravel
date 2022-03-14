package com.apirest.financiero.controllers;

import java.util.List;


import com.apirest.financiero.models.entity.CTipoUso;
import com.apirest.financiero.models.services.CTipoUsoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")
public class CTipoUsoController {

    @Autowired
    private CTipoUsoService cTipoUsoService;

    @GetMapping("/ctipouso/list")
    public List<CTipoUso> findAll() {
        return cTipoUsoService.findAll();
    }

    @GetMapping("/ctipouso/list/idtip/{IdTip}")
    public List<CTipoUso> findAll(@PathVariable("IdTip") short IdTip) {
        return cTipoUsoService.findByIdTip(IdTip);
    }
    
}
