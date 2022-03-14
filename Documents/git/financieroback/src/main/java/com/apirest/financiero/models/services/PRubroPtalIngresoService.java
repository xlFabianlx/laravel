package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPRubroPtalIngresoDao;
import com.apirest.financiero.models.entity.PRubroPtalIngreso;
import com.apirest.financiero.models.entity.PRubroPtalIngresoPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRubroPtalIngresoService implements IPRubroPtalIngresoService{
    @Autowired
    private IPRubroPtalIngresoDao iPRubroPtalIngresoDao;

    @Override
    public List<PRubroPtalIngreso> findAll() {
        return iPRubroPtalIngresoDao.findAll();
    }

    @Override
    public PRubroPtalIngreso findById(PRubroPtalIngresoPK pRubroPtalIngresoPK) {
        return iPRubroPtalIngresoDao.findById(pRubroPtalIngresoPK).orElse(null);
    }

    @Override
    public PRubroPtalIngreso save(PRubroPtalIngreso pRubroPtalIngreso) {
        return iPRubroPtalIngresoDao.save(pRubroPtalIngreso);
    }

    @Override
    public void deleteById(PRubroPtalIngresoPK pRubroPtalIngresoPK) {
        iPRubroPtalIngresoDao.deleteById(pRubroPtalIngresoPK);
    }
}
