package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPModPtalEncDao;
import com.apirest.financiero.models.entity.PModPtalEnc;
import com.apirest.financiero.models.entity.PModPtalEncPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PModPtalEncService implements IPModPtalEncService {
    @Autowired
    private IPModPtalEncDao iPModPtalEncDao;

    @Override
    public List<PModPtalEnc> findAll() {
        return iPModPtalEncDao.findAll();
    }

    @Override
    public PModPtalEnc findById(PModPtalEncPK pModPtalEncPK) {
        return iPModPtalEncDao.findById(pModPtalEncPK).orElse(null);
    }

    @Override
    public PModPtalEnc save(PModPtalEnc pModPtalEnc) {
        return iPModPtalEncDao.save(pModPtalEnc);
    }

    @Override
    public void deleteById(PModPtalEncPK pModPtalEncPK) {
        iPModPtalEncDao.deleteById(pModPtalEncPK);
    }
}
