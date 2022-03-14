package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICClaseDao;
import com.apirest.financiero.models.entity.CClase;
import com.apirest.financiero.models.entity.CClasePK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CClaseService {
    @Autowired
    private ICClaseDao iCClaseDao;

    public List<CClase> findAll() {
        return iCClaseDao.findAll();
    }

    public List<CClase> findByIdcla(Short Idcla){
        return iCClaseDao.findByIdcla(Idcla); 
    }

    public CClase findById(CClasePK cClasePK){
        return iCClaseDao.findById(cClasePK).orElse(null);
    }

    public CClase save(CClase cClase){
        return iCClaseDao.save(cClase);
    }
}
