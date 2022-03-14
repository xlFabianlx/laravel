package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PModPtaIngEnc;
import com.apirest.financiero.models.entity.PModPtaIngEncPK;

import java.util.List;

public interface IPModPtaIngEncService {
    List<PModPtaIngEnc> findAll();

    PModPtaIngEnc findById(PModPtaIngEncPK pModPtaIngEncPK);

    PModPtaIngEnc save(PModPtaIngEnc pModPtaIngEnc);

    void deleteById(PModPtaIngEncPK pModPtaIngEncPK);
}
