package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICAcuContablidadDao;
import com.apirest.financiero.models.entity.CAcuContablidad;
import com.apirest.financiero.models.entity.CAcuContablidadPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CAcuContablidadService {

    @Autowired
    private ICAcuContablidadDao iCAcuContablidadDao; 

    public List<CAcuContablidad> findAll() {
        return iCAcuContablidadDao.findAll();
    }

    public CAcuContablidad findByPK(CAcuContablidadPK cAcuContablidadPK) {
        return iCAcuContablidadDao.findById(cAcuContablidadPK).orElse(null);
    }

    public CAcuContablidad save(CAcuContablidad cAcuContablidad) {
        return iCAcuContablidadDao.save(cAcuContablidad);
    }
    
}