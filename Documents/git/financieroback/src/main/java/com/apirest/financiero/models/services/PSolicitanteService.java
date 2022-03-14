package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPSolicitanteDao;
import com.apirest.financiero.models.entity.PSolicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSolicitanteService implements IPSolicitanteService{
    @Autowired
    private IPSolicitanteDao iPSolicitanteDao;

    @Override
    public List<PSolicitante> findAll() {
        return iPSolicitanteDao.findAll();
    }

    @Override
    public PSolicitante findById(String soliCod) {
        return iPSolicitanteDao.findById(soliCod).orElse(null);
    }

    @Override
    public PSolicitante save(PSolicitante pSolicitante) {
        return iPSolicitanteDao.save(pSolicitante);
    }

    @Override
    public void deleteById(String soliCod) {
        iPSolicitanteDao.deleteById(soliCod);
    }
}
