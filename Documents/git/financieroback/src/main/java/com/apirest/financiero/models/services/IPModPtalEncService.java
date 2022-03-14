package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PModPtalEnc;
import com.apirest.financiero.models.entity.PModPtalEncPK;

import java.util.List;

public interface IPModPtalEncService {
    public List<PModPtalEnc> findAll();

    public PModPtalEnc findById(PModPtalEncPK pModPtalEncPK);

    public PModPtalEnc save(PModPtalEnc pModPtalEnc);

    public void deleteById(PModPtalEncPK pModPtalEncPK);
}
