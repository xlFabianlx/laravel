package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.RolesRutaDao;
import com.apirest.financiero.models.entity.RolesRuta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RolesRutaService {
    @Autowired
    private RolesRutaDao rolesRutaDao;

    
    public List<RolesRuta> findAll(){
    return rolesRutaDao.findAll();
    }

    
    public RolesRuta findById(Short id){
        return rolesRutaDao.findById(id).orElse(null);
    }
}
