package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.POrdenadorGasto;

import java.util.List;

public interface IPOrdenadorGastoService {
    List<POrdenadorGasto> findAll();

    POrdenadorGasto findById(String ordCod);

    POrdenadorGasto save(POrdenadorGasto pOrdenadorGasto);

    void deleteById(String ordCod);
}
