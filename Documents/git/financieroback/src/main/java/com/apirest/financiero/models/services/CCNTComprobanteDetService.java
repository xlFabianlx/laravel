package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICNTComprobanteDetDao;
import com.apirest.financiero.models.entity.CNTComprobanteDet;
import com.apirest.financiero.models.entity.CNTComprobanteDetPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCNTComprobanteDetService {

    @Autowired
    private ICNTComprobanteDetDao iCNTComprobanteDetDao;

    public List<CNTComprobanteDet> findAll(){
        return iCNTComprobanteDetDao.findAll();
    }
    
    public CNTComprobanteDet findByPK(CNTComprobanteDetPK cNTComprobanteDetPK){
        return iCNTComprobanteDetDao.findById(cNTComprobanteDetPK).orElse(null);
    }

    public CNTComprobanteDet save(CNTComprobanteDet cNTComprobanteDet){
        return iCNTComprobanteDetDao.save(cNTComprobanteDet);
    }
}
