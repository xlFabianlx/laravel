package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.CCNTSaldoInicial;
import com.apirest.financiero.models.services.CCNTSaldoInicialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/api/v1/")
public class CCNTSaldoInicialController {
    
    @Autowired
    private CCNTSaldoInicialService cCNTSaldoInicialService;

    @GetMapping("cCNTSaldoInicial/list")
    public List<CCNTSaldoInicial> findAllSaldo(){
        return cCNTSaldoInicialService.findAllSaldo();
    }
}
