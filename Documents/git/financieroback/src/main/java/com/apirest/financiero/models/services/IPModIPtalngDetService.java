package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PModIPtalngDet;
import com.apirest.financiero.models.entity.PModIPtalngDetPK;

import java.util.List;

public interface IPModIPtalngDetService {
    List<PModIPtalngDet> findAll();

    PModIPtalngDet findById(PModIPtalngDetPK pModIPtalngDetPK);

    PModIPtalngDet save(PModIPtalngDet pModIPtalngDet);

    void deleteById(PModIPtalngDetPK pModIPtalngDetPK);
}
