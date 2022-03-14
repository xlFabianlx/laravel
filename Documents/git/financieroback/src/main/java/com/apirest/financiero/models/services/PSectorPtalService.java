package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPSectorPtalDao;
import com.apirest.financiero.models.entity.PSectorPtal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PSectorPtalService implements IPSectorPtalService {
    @Autowired
    private IPSectorPtalDao iPSectorPtalDao;

    @Override
    public List<PSectorPtal> findAll() {
        return iPSectorPtalDao.findAll();
    }

    @Override
    public PSectorPtal findById(String sectorcodigo) {
        return iPSectorPtalDao.findById(sectorcodigo).orElse(null);
    }

    @Override
    public PSectorPtal save(PSectorPtal pSectorPtal) {
        return iPSectorPtalDao.save(pSectorPtal);
    }

    @Override
    public void deleteById(String sectorcodigo) {
        iPSectorPtalDao.deleteById(sectorcodigo);
    }
}
