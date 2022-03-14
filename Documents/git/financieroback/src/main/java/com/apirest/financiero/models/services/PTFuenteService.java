package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPTFuenteDao;
import com.apirest.financiero.models.entity.PTFuente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PTFuenteService implements IPTFuenteService {

    @Autowired
    private IPTFuenteDao Service;

    @Override
    public PTFuente save(PTFuente modelo) {
        return Service.save(modelo);
    }

    @Override
    public List<PTFuente> findAll() {
        return Service.findAll();
    }

    @Override
    public PTFuente findById(Short id) {
        return Service.findById(id).orElse(null);
    }
}
