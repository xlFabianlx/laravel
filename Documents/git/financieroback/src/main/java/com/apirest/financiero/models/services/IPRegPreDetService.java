package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PRegPreDet;
import com.apirest.financiero.models.entity.PRegPreDetPK;

import java.util.List;

public interface IPRegPreDetService {
    List<PRegPreDet> findAll();

    PRegPreDet findById(PRegPreDetPK pRegPreDetPK);

    PRegPreDet save(PRegPreDet pRegPreDet);

    void deleteById(PRegPreDetPK pRegPreDetPK);
}
