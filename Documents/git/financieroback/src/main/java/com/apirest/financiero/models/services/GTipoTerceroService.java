package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.GTipoTerceroDao;
import com.apirest.financiero.models.entity.GTipoTercero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GTipoTerceroService {

    @Autowired
    private GTipoTerceroDao dao;
    
    public List<GTipoTercero> findAll(){
        return dao.findAll();
    }
}