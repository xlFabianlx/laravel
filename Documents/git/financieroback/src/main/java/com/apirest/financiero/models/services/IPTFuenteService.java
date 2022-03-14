package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PTFuente;

import java.util.List;

public interface IPTFuenteService {
    List<PTFuente> findAll();
    PTFuente findById(Short id);
    PTFuente save(PTFuente modelo);
}
