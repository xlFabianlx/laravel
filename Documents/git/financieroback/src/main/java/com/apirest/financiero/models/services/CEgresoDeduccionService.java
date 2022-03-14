package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICEgresoDeduccionDao;
import com.apirest.financiero.models.entity.CEgresoDeduccion;
import com.apirest.financiero.models.entity.CEgresoDeduccionPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CEgresoDeduccionService {

    @Autowired
    private ICEgresoDeduccionDao iCEgresoDeduccionDao; 

    public List<CEgresoDeduccion> findAll() {
        return iCEgresoDeduccionDao.findAll();
    }

    public CEgresoDeduccion findByPK(CEgresoDeduccionPK CEgresoDeduccionPK) {
        return iCEgresoDeduccionDao.findById(CEgresoDeduccionPK).orElse(null);
    }

    public CEgresoDeduccion save(CEgresoDeduccion cEgresoDeduccion) {
        return iCEgresoDeduccionDao.save(cEgresoDeduccion);
    }
}
