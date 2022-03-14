package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.GSiaCatalogoCuentaDao;
import com.apirest.financiero.models.entity.GSiaCatalogoCuenta;
import com.apirest.financiero.models.entity.GSiaCatalogoCuentaPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GSiaCatalogoCuentaService implements IGSiaCatalogoCuentaService{
    
    @Autowired
    private GSiaCatalogoCuentaDao siaCatCuentDao;

    @Override
    public List<GSiaCatalogoCuenta> findAll() {
        return siaCatCuentDao.findAll();
    }

    @Override
    public GSiaCatalogoCuenta findById(GSiaCatalogoCuentaPK siacatcuentPk) {
        return siaCatCuentDao.findById(siacatcuentPk).orElse(null);
    }

    @Override
    public GSiaCatalogoCuenta save(GSiaCatalogoCuenta gsiacatcuent) {
        return siaCatCuentDao.save(gsiacatcuent);
    }

    @Override
    public void deleteById(GSiaCatalogoCuentaPK siacatcuentPk) {
        siaCatCuentDao.deleteById(siacatcuentPk);
    }
    
    
}
