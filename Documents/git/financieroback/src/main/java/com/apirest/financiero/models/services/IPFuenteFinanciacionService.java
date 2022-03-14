package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PFuenteFinanciacion;

import java.util.List;

public interface IPFuenteFinanciacionService {
    public List<PFuenteFinanciacion> findAll();

    public PFuenteFinanciacion findById(Short fueCod);

    public PFuenteFinanciacion save(PFuenteFinanciacion pFuenteFinanciacion);

    public void deleteById(Short fueCod);
}
