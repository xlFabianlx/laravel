package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPModIPtalngDetDao;
import com.apirest.financiero.models.entity.PModIPtalngDet;
import com.apirest.financiero.models.entity.PModIPtalngDetPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PModIPtalngDetService implements IPModIPtalngDetService{
    @Autowired
    private IPModIPtalngDetDao iPModIPtalngDetDao;

    @Override
    public List<PModIPtalngDet> findAll() {
        return iPModIPtalngDetDao.findAll();
    }

    @Override
    public PModIPtalngDet findById(PModIPtalngDetPK pModIPtalngDetPK) {
        return iPModIPtalngDetDao.findById(pModIPtalngDetPK).orElse(null);
    }

    @Override
    public PModIPtalngDet save(PModIPtalngDet pModIPtalngDet) {
        return iPModIPtalngDetDao.save(pModIPtalngDet);
    }

    @Override
    public void deleteById(PModIPtalngDetPK pModIPtalngDetPK) {
        iPModIPtalngDetDao.deleteById(pModIPtalngDetPK);
    }

}
