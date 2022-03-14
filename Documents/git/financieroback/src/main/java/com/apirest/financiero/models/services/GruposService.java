package com.apirest.financiero.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.apirest.financiero.models.dao.GruposDao;
import com.apirest.financiero.models.entity.Grupos;


@Service
public class GruposService {
    
    @Autowired
    private GruposDao gruposDao;

    public List<Grupos> findAllGrupos() {
        return gruposDao.findAllGrupos();
    }
}
