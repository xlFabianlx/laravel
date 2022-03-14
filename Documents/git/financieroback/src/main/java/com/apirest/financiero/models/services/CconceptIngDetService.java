package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICconceptIngDetDao;
import com.apirest.financiero.models.entity.CconceptIngDet;
import com.apirest.financiero.models.entity.CconceptIngDetPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CconceptIngDetService {

    @Autowired
    private ICconceptIngDetDao iCComprobanteContEncDao; 

    public List<CconceptIngDet> findAll() {
        return iCComprobanteContEncDao.findAll();
    }

    public CconceptIngDet findByPK(CconceptIngDetPK cconceptIngDetPK) {
        return iCComprobanteContEncDao.findById(cconceptIngDetPK).orElse(null);
    }

    public CconceptIngDet save(CconceptIngDet cconceptIngDet) {
        return iCComprobanteContEncDao.save(cconceptIngDet);
    }
    
}