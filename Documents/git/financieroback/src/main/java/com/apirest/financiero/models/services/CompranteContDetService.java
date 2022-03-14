package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IComprobanteContDetDao;
import com.apirest.financiero.models.entity.CComprobanteContDet;
import com.apirest.financiero.models.entity.CComprobanteContDetPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompranteContDetService implements IComprobContDetService{
    
    @Autowired
    private IComprobanteContDetDao compContDetDao;

    @Override
    public List <CComprobanteContDet> findAll() {
        return compContDetDao.findAll();
    }

    @Override
    public CComprobanteContDet findById(CComprobanteContDetPK comprobanteContDetPK) {
        return compContDetDao.findById(comprobanteContDetPK).orElse(null);
    }

    @Override
    public CComprobanteContDet save(CComprobanteContDet comprobContDet) {
        return compContDetDao.save(comprobContDet);
    }

    @Override
    public void deleteById(CComprobanteContDetPK comprobanteContDetPK) {
        compContDetDao.deleteById(comprobanteContDetPK);
    }
}
