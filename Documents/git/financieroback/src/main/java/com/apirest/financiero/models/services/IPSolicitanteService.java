package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PSolicitante;

import java.util.List;

public interface IPSolicitanteService {
    List<PSolicitante> findAll();

    PSolicitante findById(String soliCod);

    PSolicitante save(PSolicitante pSolicitante);

    void deleteById(String soliCod);
}
