package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.RutasDao;
import com.apirest.financiero.models.entity.Rutas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutasService {
    @Autowired
    private RutasDao rutasDao;

    
    public List<Rutas> findAll(){
    return rutasDao.findAll();
    }

    
    public Rutas findById(Short id){
        return rutasDao.findById(id).orElse(null);
    }
    
}
