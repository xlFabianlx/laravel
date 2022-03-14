package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPFormatoRendicionDao;
import com.apirest.financiero.models.entity.PFormatoRendicion;
import com.apirest.financiero.models.entity.PFormatoRendicionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PFormatoRendicionService implements IPFormatoRendicionService{
    @Autowired
    private IPFormatoRendicionDao iPFormatoRendicionDao;

    @Override
    public List<PFormatoRendicion> findAll() {
        return iPFormatoRendicionDao.findAll();
    }

    @Override
    public PFormatoRendicion findById(PFormatoRendicionPK pFormatoRendicionPK) {
        return iPFormatoRendicionDao.findById(pFormatoRendicionPK).orElse(null);
    }

    @Override
    public PFormatoRendicion save(PFormatoRendicion pFormatoRendicion) {
        return iPFormatoRendicionDao.save(pFormatoRendicion);
    }

    @Override
    public void deleteById(PFormatoRendicionPK pFormatoRendicionPK) {
        iPFormatoRendicionDao.deleteById(pFormatoRendicionPK);
    }
}
