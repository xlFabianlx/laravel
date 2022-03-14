package com.apirest.financiero.models.services;


import com.apirest.financiero.models.entity.PCertDispPtalEnc;
import com.apirest.financiero.models.entity.PCertDispPtalEncPK;

import java.util.List;

public interface IPCertDispPtalEncService {
    public List<PCertDispPtalEnc> findAll();

    public PCertDispPtalEnc findById(PCertDispPtalEncPK pCertDispPtalDetPK);

    public PCertDispPtalEnc save(PCertDispPtalEnc pCertDispPtalDet);

    public void deleteById(PCertDispPtalEncPK pCertDispPtalDetPK);
}
