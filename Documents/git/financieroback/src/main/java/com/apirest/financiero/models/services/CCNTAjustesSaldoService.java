package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICNTAjustesSaldoDao;
import com.apirest.financiero.models.entity.CCNTAjustesSaldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCNTAjustesSaldoService {
    
    @Autowired
    private ICNTAjustesSaldoDao iCNTAjustesSaldoDao;

    public List<CCNTAjustesSaldo> findAllAjustesSaldo() {
        return iCNTAjustesSaldoDao.findAllAjustesSaldo();
    }
    
}
