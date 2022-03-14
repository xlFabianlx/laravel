package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICCuentaEquivalenteDao;
import com.apirest.financiero.models.entity.CCuentaEquivalente;
import com.apirest.financiero.models.entity.CCuentaEquivalentePK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCuentaEquivalenteService {

    @Autowired
    private ICCuentaEquivalenteDao ICCuentaEquivalenteDao; 

    public List<CCuentaEquivalente> findAll() {
        return ICCuentaEquivalenteDao.findAll();
    }

    public CCuentaEquivalente findByPK(CCuentaEquivalentePK cCuentaEquivalentePK) {
        return ICCuentaEquivalenteDao.findById(cCuentaEquivalentePK).orElse(null);
    }

    public CCuentaEquivalente save(CCuentaEquivalente cCuentaEquivalente) {
        return ICCuentaEquivalenteDao.save(cCuentaEquivalente);
    }
    
}