package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICPerContableDao;
import com.apirest.financiero.models.entity.CPerContable;
import com.apirest.financiero.models.entity.CPerContablePK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPerContableService {

    @Autowired
    private ICPerContableDao iCPerContableDao; 

    public List<CPerContable> findAll() {
        return iCPerContableDao.findAll();
    }

    public CPerContable findByPK(CPerContablePK cPerContablePK) {
        return iCPerContableDao.findById(cPerContablePK).orElse(null);
    }

    public CPerContable save(CPerContable cPerContable) {
        return iCPerContableDao.save(cPerContable);
    }
}
