package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.GRegimenDao;
import com.apirest.financiero.models.entity.GRegimen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GRegimenService {

    @Autowired
    private GRegimenDao dao;
    
    public List<GRegimen> findAll(){
        return dao.findAll();
    }
}