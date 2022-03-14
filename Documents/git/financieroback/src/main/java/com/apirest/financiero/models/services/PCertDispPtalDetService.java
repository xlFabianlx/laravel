package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPCertDispPtalDetDao;
import com.apirest.financiero.models.entity.PCertDispPtalDet;
import com.apirest.financiero.models.entity.PCertDispPtalDetPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCertDispPtalDetService implements IPCertDispPtalDetService {
    @Autowired
    private IPCertDispPtalDetDao iPCertDispPtalDetDao;

    @Override
    public List<PCertDispPtalDet> findAll() {
        return iPCertDispPtalDetDao.findAll();
    }

    @Override
    public PCertDispPtalDet findById(PCertDispPtalDetPK pCertDispPtalDetPK) {
        return iPCertDispPtalDetDao.findById(pCertDispPtalDetPK).orElse(null);
    }

    @Override
    public PCertDispPtalDet save(PCertDispPtalDet pCertDispPtalDet) {
        return iPCertDispPtalDetDao.save(pCertDispPtalDet);
    }

    @Override
    public void deleteById(PCertDispPtalDetPK pCertDispPtalDetPK) {
        iPCertDispPtalDetDao.deleteById(pCertDispPtalDetPK);
    }

}
