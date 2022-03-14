package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.CComprobanteContDet;
import com.apirest.financiero.models.entity.CComprobanteContDetPK;

import java.util.List;


public interface IComprobContDetService {
    public List<CComprobanteContDet> findAll();

    public CComprobanteContDet findById(CComprobanteContDetPK comprobanteContDetPK);

    public CComprobanteContDet save(CComprobanteContDet comprobContDet);

    public void deleteById(CComprobanteContDetPK comprobanteContDetPK);
}
