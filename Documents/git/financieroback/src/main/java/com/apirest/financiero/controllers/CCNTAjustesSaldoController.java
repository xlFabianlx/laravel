package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.CCNTAjustesSaldo;
import com.apirest.financiero.models.services.CCNTAjustesSaldoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1")

public class CCNTAjustesSaldoController {
    
    @Autowired
    private CCNTAjustesSaldoService cCNTAjustesSaldoService;

    @GetMapping("ajustesSaldo/List")
    public List<CCNTAjustesSaldo> findAllAjustesSaldo(){
        return cCNTAjustesSaldoService.findAllAjustesSaldo();
    }
}
