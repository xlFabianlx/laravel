package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPModPtaIngEncDao;
import com.apirest.financiero.models.entity.PModPtaIngEnc;
import com.apirest.financiero.models.entity.PModPtaIngEncPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PModPtaIngEncService implements IPModPtaIngEncService{
    @Autowired
    private IPModPtaIngEncDao IPModPtaIngEncDao;

    @Override
    public List<PModPtaIngEnc> findAll() {
        return IPModPtaIngEncDao.findAll();
    }

    @Override
    public PModPtaIngEnc findById(PModPtaIngEncPK pModPtaIngEncPK) {
        return IPModPtaIngEncDao.findById(pModPtaIngEncPK).orElse(null);
    }

    @Override
    public PModPtaIngEnc save(PModPtaIngEnc pModPtaIngEnc) {
        return IPModPtaIngEncDao.save(pModPtaIngEnc);
    }

    @Override
    public void deleteById(PModPtaIngEncPK pModPtaIngEncPK) {
        IPModPtaIngEncDao.deleteById(pModPtaIngEncPK);
    }
}
