package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PCertDispPtalDet;
import com.apirest.financiero.models.entity.PCertDispPtalDetPK;

import java.util.List;

public interface IPCertDispPtalDetService {
    public List<PCertDispPtalDet> findAll();

    public PCertDispPtalDet findById(PCertDispPtalDetPK pCertDispPtalDetPK);

    public PCertDispPtalDet save(PCertDispPtalDet pCertDispPtalDet);

    public void deleteById(PCertDispPtalDetPK pCertDispPtalDetPK);
}
