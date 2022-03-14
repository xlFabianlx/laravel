package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NParafiscalDao;
import com.apirest.financiero.models.entity.NParafiscales;
import com.apirest.financiero.models.entity.NParafiscalesPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NParafiscalService implements INParafiscalService{

    @Autowired
    private NParafiscalDao nParafiscalDao;
    
    @Override
    public List<NParafiscales> findAll() {
        return nParafiscalDao.findAll();
    }

    @Override
    public NParafiscales findById(NParafiscalesPK nParafiscalesPK) {
       return nParafiscalDao.findById(nParafiscalesPK).orElse(null);
    }

    @Override
    public NParafiscales save(NParafiscales nParafiscales) {
        return nParafiscalDao.save(nParafiscales);
    }

    @Override
    public void deleteById(NParafiscalesPK id) {
        nParafiscalDao.deleteById(id);
    }
    
}
