package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IGSiaCompromisoDao;
import com.apirest.financiero.models.entity.GSiaCompromiso;
import com.apirest.financiero.models.entity.GSiaCompromisoPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GSiaCompromisoService implements IGSiaCompromisoService{
    
    @Autowired
    private IGSiaCompromisoDao siaCompromisoDao;

    @Override
    public List<GSiaCompromiso> findAll() {
        return siaCompromisoDao.findAll();
    }

    @Override
    public GSiaCompromiso findById(GSiaCompromisoPK siaCompromisoPk) {
        return siaCompromisoDao.findById(siaCompromisoPk).orElse(null);
    }

    @Override
    public GSiaCompromiso save(GSiaCompromiso siaCompromiso) {
        return siaCompromisoDao.save(siaCompromiso);
    }

    @Override
    public void deleteById(GSiaCompromisoPK siaCompromisoPk) {
        siaCompromisoDao.deleteById(siaCompromisoPk);
    }
    
    
    
}
