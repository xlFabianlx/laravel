package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPFuenteFutDao;
import com.apirest.financiero.models.entity.PFuenteFut;
import com.apirest.financiero.models.entity.PFuenteFutPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PFuenteFutService implements IPFuenteFutService{
    @Autowired
    private IPFuenteFutDao iPFuenteFutDao;

    @Override
    public List<PFuenteFut> findAll() {
        return iPFuenteFutDao.findAll();
    }

    @Override
    public PFuenteFut findById(PFuenteFutPK pFuenteFutPK) {
        return iPFuenteFutDao.findById(pFuenteFutPK).orElse(null);
    }

    @Override
    public PFuenteFut save(PFuenteFut pFuenteFut) {
        return iPFuenteFutDao.save(pFuenteFut);
    }

    @Override
    public void deleteById(PFuenteFutPK pFuenteFutPK) {
        iPFuenteFutDao.deleteById(pFuenteFutPK);
    }
}
