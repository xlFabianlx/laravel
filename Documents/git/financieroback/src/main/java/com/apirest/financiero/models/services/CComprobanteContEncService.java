
package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.CComprobanteContEnc;
import com.apirest.financiero.models.entity.CComprobanteContEncPK;
import com.apirest.financiero.models.dao.ICComprobanteContEncDao;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CComprobanteContEncService {

    @Autowired
    private ICComprobanteContEncDao iCComprobanteContEncDao; 

    public List<CComprobanteContEnc> findAll() {
        return iCComprobanteContEncDao.findAll();
    }

    public CComprobanteContEnc findByPK(CComprobanteContEncPK cComprobanteContEncPK) {
        return iCComprobanteContEncDao.findById(cComprobanteContEncPK).orElse(null);
    }

    public CComprobanteContEnc save(CComprobanteContEnc cComprobanteContEnc) {
        return iCComprobanteContEncDao.save(cComprobanteContEnc);
    }
    
}