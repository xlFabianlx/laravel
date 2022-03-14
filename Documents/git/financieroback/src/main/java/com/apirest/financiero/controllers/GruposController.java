package com.apirest.financiero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apirest.financiero.models.entity.Grupos;
import com.apirest.financiero.models.services.GruposService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class GruposController {
    
    @Autowired
    private GruposService gruposService;

    @GetMapping("/grupos/list")
    public List<Grupos> findAllGrupos(){
        return gruposService.findAllGrupos();
    }
}
