package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPOrdenadorGastoDao;
import com.apirest.financiero.models.entity.POrdenadorGasto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POrdenadorGastoService implements IPOrdenadorGastoService{
    @Autowired
    private IPOrdenadorGastoDao iPOrdenadorGastoDao;

    @Override
    public List<POrdenadorGasto> findAll() {
        return iPOrdenadorGastoDao.findAll();
    }

    @Override
    public POrdenadorGasto findById(String ordCod) {
        return iPOrdenadorGastoDao.findById(ordCod).orElse(null);
    }

    @Override
    public POrdenadorGasto save(POrdenadorGasto pOrdenadorGasto) {
        return iPOrdenadorGastoDao.save(pOrdenadorGasto);
    }

    @Override
    public void deleteById(String ordCod) {
        iPOrdenadorGastoDao.deleteById(ordCod);
    }
}
