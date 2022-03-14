package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.GTipoDocumentoDao;
import com.apirest.financiero.models.entity.GTipoDocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GTipoDocumentoService {

    @Autowired
    private GTipoDocumentoDao dao;
    
    public List<GTipoDocumento> findAll(){
        return dao.findAll();
    }
}