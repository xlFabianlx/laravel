package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPCertDispPtalEncDao;
import com.apirest.financiero.models.entity.PCertDispPtalEnc;
import com.apirest.financiero.models.entity.PCertDispPtalEncPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PCertDispPtalEncService implements IPCertDispPtalEncService{
    @Autowired
    private IPCertDispPtalEncDao iPCertDispPtalEncDao;

    @Override
    public List<PCertDispPtalEnc> findAll() {
        return iPCertDispPtalEncDao.findAll();
    }

    @Override
    public PCertDispPtalEnc findById(PCertDispPtalEncPK pCertDispPtalDetPK) {
        return iPCertDispPtalEncDao.findById(pCertDispPtalDetPK).orElse(null);
    }

    @Override
    public PCertDispPtalEnc save(PCertDispPtalEnc pCertDispPtalDet) {
        return iPCertDispPtalEncDao.save(pCertDispPtalDet);
    }

    @Override
    public void deleteById(PCertDispPtalEncPK pCertDispPtalDetPK) {
        iPCertDispPtalEncDao.deleteById(pCertDispPtalDetPK);
    }

}
