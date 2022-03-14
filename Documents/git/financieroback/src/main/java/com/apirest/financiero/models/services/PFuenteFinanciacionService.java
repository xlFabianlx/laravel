package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPFuenteFinanciacionDao;
import com.apirest.financiero.models.entity.PFuenteFinanciacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PFuenteFinanciacionService implements IPFuenteFinanciacionService{
    @Autowired
    private IPFuenteFinanciacionDao iPFuenteFinanciacionDao;

    @Override
    public List<PFuenteFinanciacion> findAll() {
        return iPFuenteFinanciacionDao.findAll();
    }

    @Override
    public PFuenteFinanciacion findById(Short fueCod) {
        return iPFuenteFinanciacionDao.findById(fueCod).orElse(null);
    }

    @Override
    public PFuenteFinanciacion save(PFuenteFinanciacion pFuenteFinanciacion) {
        return iPFuenteFinanciacionDao.save(pFuenteFinanciacion);
    }

    @Override
    public void deleteById(Short pFuenteFinanciacion) {
        iPFuenteFinanciacionDao.deleteById(pFuenteFinanciacion);
    }
}
