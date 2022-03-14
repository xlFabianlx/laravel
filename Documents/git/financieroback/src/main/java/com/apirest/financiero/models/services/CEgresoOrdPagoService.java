package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICEgresoOrdPagoDao;
import com.apirest.financiero.models.entity.CEgresoOrdPago;
import com.apirest.financiero.models.entity.CEgresoOrdPagoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CEgresoOrdPagoService {

    @Autowired
    private ICEgresoOrdPagoDao iCEgresoOrdPagoDao; 

    public List<CEgresoOrdPago> findAll() {
        return iCEgresoOrdPagoDao.findAll();
    }

    public CEgresoOrdPago findByPK(CEgresoOrdPagoPK  cEgresoOrdPagoPK) {
        return iCEgresoOrdPagoDao.findById(cEgresoOrdPagoPK).orElse(null);
    }

    public CEgresoOrdPago save(CEgresoOrdPago  cEgresoOrdPago) {
        return iCEgresoOrdPagoDao.save(cEgresoOrdPago);
    }
    
}