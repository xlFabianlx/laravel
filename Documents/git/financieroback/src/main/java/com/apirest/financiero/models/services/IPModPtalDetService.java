package com.apirest.financiero.models.services;


import com.apirest.financiero.models.entity.PModPtalDet;
import com.apirest.financiero.models.entity.PModPtalDetPK;
import java.util.List;

public interface IPModPtalDetService {
    List<PModPtalDet> findAll();

    PModPtalDet findById(PModPtalDetPK pModPtalDetPK);

    PModPtalDet save(PModPtalDet pModPtalDet);

    void deleteById(PModPtalDetPK pModPtalDetPK);
}
