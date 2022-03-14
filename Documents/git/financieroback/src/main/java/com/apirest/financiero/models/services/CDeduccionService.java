package com.apirest.financiero.models.services;

import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.dao.ICDeduccionDao;
import com.apirest.financiero.models.entity.CDeduccion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDeduccionService {

    @Autowired
    private ICDeduccionDao iCDeduccionDao; 

    public List<CDeduccion> findAll() {
        return iCDeduccionDao.findAll();
    }

    public CDeduccion findById(Short id) {
        return iCDeduccionDao.findById(id).orElse(null);
    }

    public CDeduccion findByDedCod(Short dedCod) {
        return iCDeduccionDao.findByDedCod(dedCod);
    }

    public CDeduccion save(CDeduccion cDeduccion) {
        return iCDeduccionDao.save(cDeduccion);
    }
    
    public List<Map<String, ?>> getDeduccionesTercerosActivos(Long terCod) {
        return iCDeduccionDao.getDeduccionesTercerosActivos(terCod);
    }
}