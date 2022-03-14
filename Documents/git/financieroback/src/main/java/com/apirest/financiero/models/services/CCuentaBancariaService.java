package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICCuentaBancariaDao;
import com.apirest.financiero.models.entity.CCuentaBancaria;
import com.apirest.financiero.models.entity.CCuentaBancariaPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCuentaBancariaService {

    @Autowired
    private ICCuentaBancariaDao iCCuentaBancariaDao; 

    public List<CCuentaBancaria> findAll() {
        return iCCuentaBancariaDao.findAll();
    }

    public CCuentaBancaria findByPK(CCuentaBancariaPK cCuentaBancariaPK) {
        return iCCuentaBancariaDao.findById(cCuentaBancariaPK).orElse(null);
    }

    public CCuentaBancaria save(CCuentaBancaria cCuentaBancaria) {
        return iCCuentaBancariaDao.save(cCuentaBancaria);
    }
    
}