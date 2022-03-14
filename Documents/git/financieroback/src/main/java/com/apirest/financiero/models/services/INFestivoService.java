package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.entity.NFestivo;

public interface INFestivoService {
    public List<NFestivo> findAll();

    public NFestivo findById(Integer id);

    public NFestivo save(NFestivo nFestivo);

    public void deleteById(Integer id);
}
