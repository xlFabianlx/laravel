package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICConpesDao;
import com.apirest.financiero.models.entity.CConpes;
import com.apirest.financiero.models.entity.CConpesPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CConpesService {

    @Autowired
    private ICConpesDao ICConpesDao; 

    public List<CConpes> findAll() {
        return ICConpesDao.findAll();
    }

    public CConpes findByPK(CConpesPK cConpesPK) {
        return ICConpesDao.findById(cConpesPK).orElse(null);
    }

    public CConpes save(CConpes cConpes) {
        return ICConpesDao.save(cConpes);
    }
    
}