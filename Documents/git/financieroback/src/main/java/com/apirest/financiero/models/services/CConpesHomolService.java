package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICConpesHomolDao;
import com.apirest.financiero.models.entity.CConpesHomol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CConpesHomolService {

    @Autowired
    private ICConpesHomolDao iCConpesHomolDao; 

    public List<CConpesHomol> findAll() {
        return iCConpesHomolDao.findAll();
    }

    public CConpesHomol findById(Integer id) {
        return iCConpesHomolDao.findById(id).orElse(null);
    }

    public CConpesHomol save(CConpesHomol cConpesHomol) {
        return iCConpesHomolDao.save(cConpesHomol);
    }
    
}