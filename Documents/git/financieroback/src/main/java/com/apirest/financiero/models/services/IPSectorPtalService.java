package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PSectorPtal;

import java.util.List;

public interface IPSectorPtalService {
    List<PSectorPtal> findAll();

    PSectorPtal findById(String sectorcodigo);

    PSectorPtal save(PSectorPtal pSectorPtal);

    void deleteById(String sectorcodigo);
}
