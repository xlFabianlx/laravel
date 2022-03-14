package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICNTSaldoInicialDao;
import com.apirest.financiero.models.entity.CCNTSaldoInicial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCNTSaldoInicialService {
    
    @Autowired
    private ICNTSaldoInicialDao iCNTSaldoInicialDao;

    
	public List<CCNTSaldoInicial> findAllSaldo() {
		return iCNTSaldoInicialDao.findAllSaldo();
    }
    
}
