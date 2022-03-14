package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPRegPreDetDao;
import com.apirest.financiero.models.entity.PRegPreDet;
import com.apirest.financiero.models.entity.PRegPreDetPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRegPreDetService implements IPRegPreDetService{
    @Autowired
    private IPRegPreDetDao iPRegPreDetDao;

    @Override
    public List<PRegPreDet> findAll() {
        return iPRegPreDetDao.findAll();
    }

    @Override
    public PRegPreDet findById(PRegPreDetPK pRegPreDetPK) {
        return iPRegPreDetDao.findById(pRegPreDetPK).orElse(null);
    }

    @Override
    public PRegPreDet save(PRegPreDet pRegPreDet) {
        return iPRegPreDetDao.save(pRegPreDet);
    }

    @Override
    public void deleteById(PRegPreDetPK pRegPreDetPK) {
        iPRegPreDetDao.deleteById(pRegPreDetPK);
    }
}
