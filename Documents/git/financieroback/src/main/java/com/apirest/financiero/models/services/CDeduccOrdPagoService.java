package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICDeduccOrdPagoDao;
import com.apirest.financiero.models.entity.CDeduccOrdPago;
import com.apirest.financiero.models.entity.CDeduccOrdPagoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CDeduccOrdPagoService {

    @Autowired
    private ICDeduccOrdPagoDao iCDeduccOrdPagoDao; 

    public List<CDeduccOrdPago> findAll() {
        return iCDeduccOrdPagoDao.findAll();
    }

    public CDeduccOrdPago findByPK(CDeduccOrdPagoPK cDeduccOrdPagoPK) {
        return iCDeduccOrdPagoDao.findById(cDeduccOrdPagoPK).orElse(null);
    }

    public CDeduccOrdPago save(CDeduccOrdPago cDeduccOrdPago) {
        return iCDeduccOrdPagoDao.save(cDeduccOrdPago);
    }
    
}