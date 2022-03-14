package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPRubroPtalDao;
import com.apirest.financiero.models.entity.PRubroPtal;
import com.apirest.financiero.models.entity.PRubroPtalPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRubroPtalService implements IPRubroPtalService{
    @Autowired
    private IPRubroPtalDao iPRubroPtalDao;

    @Override
    public List<PRubroPtal> findAll() {
        return iPRubroPtalDao.findAll();
    }

    @Override
    public PRubroPtal findById(PRubroPtalPK pRubroPtalPK) {
        return iPRubroPtalDao.findById(pRubroPtalPK).orElse(null);
    }

    @Override
    public PRubroPtal save(PRubroPtal pRubroPtal) {
        return iPRubroPtalDao.save(pRubroPtal);
    }

    @Override
    public void deleteById(PRubroPtalPK pRubroPtalPK) {
        iPRubroPtalDao.deleteById(pRubroPtalPK);
    }

    @Override
    public List<PRubroPtal> findAllRubrosConFuente() { return iPRubroPtalDao.findAllRubrosConFuente(); }
}

