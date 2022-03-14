package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICEgresoDao;
import com.apirest.financiero.models.entity.CEgreso;
import com.apirest.financiero.models.entity.CEgresoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CEgresoService {

    @Autowired
    private ICEgresoDao iCEgresoDao; 

    public List<CEgreso> findAll() {
        return iCEgresoDao.findAll();
    }

    public CEgreso findByPK(CEgresoPK cEgresoPK) {
        return iCEgresoDao.findById(cEgresoPK).orElse(null);
    }

    public CEgreso findByEgrCod(Integer egrCod) {
        return iCEgresoDao.findByEgrCod(egrCod);
    }

    public CEgreso save(CEgreso cEgreso) {
        return iCEgresoDao.save(cEgreso);
    }
    
}