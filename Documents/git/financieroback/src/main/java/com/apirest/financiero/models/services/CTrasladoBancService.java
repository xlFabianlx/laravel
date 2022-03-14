package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICTrasladoBancDao;
import com.apirest.financiero.models.entity.CTrasladoBanc;
import com.apirest.financiero.models.entity.CTrasladoBancPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CTrasladoBancService {

    @Autowired
    private ICTrasladoBancDao iCTrasladoBancDao; 

    public List<CTrasladoBanc> findAll() {
        return iCTrasladoBancDao.findAll();
    }

    public CTrasladoBanc findByPK(CTrasladoBancPK cTrasladoBancPK) {
        return iCTrasladoBancDao.findById(cTrasladoBancPK).orElse(null);
    }

    public CTrasladoBanc save(CTrasladoBanc cTrasladoBanc) {
        return iCTrasladoBancDao.save(cTrasladoBanc);
    }
    
}