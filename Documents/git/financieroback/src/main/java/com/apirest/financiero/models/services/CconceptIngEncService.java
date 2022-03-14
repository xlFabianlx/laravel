package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICconceptIngEncDao;
import com.apirest.financiero.models.entity.CconceptIngEnc;
import com.apirest.financiero.models.entity.CconceptIngEncPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CconceptIngEncService {

    @Autowired
    private ICconceptIngEncDao iCconceptIngEncDao; 

    public List<CconceptIngEnc> findAll() {
        return iCconceptIngEncDao.findAll();
    }

    public CconceptIngEnc findByPK(CconceptIngEncPK cconceptIngEncPK) {
        return iCconceptIngEncDao.findById(cconceptIngEncPK).orElse(null);
    }

    public CconceptIngEnc save(CconceptIngEnc cconceptIngEnc) {
        return iCconceptIngEncDao.save(cconceptIngEnc);
    }
    
}