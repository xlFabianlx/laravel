package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPModPtalDetDao;
import com.apirest.financiero.models.entity.PModPtalDet;
import com.apirest.financiero.models.entity.PModPtalDetPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PModPtalDetService implements IPModPtalDetService{
    @Autowired
    private IPModPtalDetDao iPModPtalDetDao;

    @Override
    public List<PModPtalDet> findAll() {
        return iPModPtalDetDao.findAll();
    }

    @Override
    public PModPtalDet findById(PModPtalDetPK pModPtalDetPK) {
        return iPModPtalDetDao.findById(pModPtalDetPK).orElse(null);
    }

    @Override
    public PModPtalDet save(PModPtalDet pModPtalDet) {
        return iPModPtalDetDao.save(pModPtalDet);
    }

    @Override
    public void deleteById(PModPtalDetPK pModPtalDetPK) {
        iPModPtalDetDao.deleteById(pModPtalDetPK);
    }
}
