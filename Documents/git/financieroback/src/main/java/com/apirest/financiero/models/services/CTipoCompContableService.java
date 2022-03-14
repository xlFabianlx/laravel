package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICTipoCompContableDao;
import com.apirest.financiero.models.entity.CTipoCompContable;
import com.apirest.financiero.models.entity.CTipoCompContablePK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CTipoCompContableService {

    @Autowired 
    private ICTipoCompContableDao iCTipoCompContableDao; 

    public List<CTipoCompContable> findAll() {
        return iCTipoCompContableDao.findAll();
    }

    public CTipoCompContable findByPK(CTipoCompContablePK cTipoCompContablePK) {
        return iCTipoCompContableDao.findById(cTipoCompContablePK).orElse(null);
    }

    public CTipoCompContable save(CTipoCompContable cTipoCompContable) {
        return iCTipoCompContableDao.save(cTipoCompContable);
    }

    public Long findTipo(){
        return iCTipoCompContableDao.findTipo();
    }

    public void delete(CTipoCompContablePK id) {
        iCTipoCompContableDao.deleteById(id);
    }
}