package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.VigenciasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VigenciasService {

    @Autowired
    private VigenciasDao vigenciasDao;

    public List<Short> getVigencias(){
        return vigenciasDao.getVigencias();
    }
}
