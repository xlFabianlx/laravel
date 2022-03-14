package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PRegPreEnc;
import com.apirest.financiero.models.entity.PRegPreEncPK;

import java.util.List;

public interface IPRegPreEncService {
    List<PRegPreEnc> findAll();

    PRegPreEnc findById(PRegPreEncPK pRegPreEncPK);

    PRegPreEnc save(PRegPreEnc pRegPreEnc);

    void deleteById(PRegPreEncPK pRegPreEncPK);
}
