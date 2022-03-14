package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPRendicionDao;
import com.apirest.financiero.models.entity.PRendicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRendicionService implements IPRendicionService{
    @Autowired
    private IPRendicionDao iPRendicionDao;

    @Override
    public List<PRendicion> findAll() {
        return iPRendicionDao.findAll();
    }

    @Override
    public PRendicion findById(Short perRendCod) {
        return iPRendicionDao.findById(perRendCod).orElse(null);
    }

    @Override
    public PRendicion save(PRendicion pRendicion) {
        return iPRendicionDao.save(pRendicion);
    }

    @Override
    public void deleteById(Short perRendCod) {
        iPRendicionDao.deleteById(perRendCod);
    }
}
