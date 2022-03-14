package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PFuenteFut;
import com.apirest.financiero.models.entity.PFuenteFutPK;

import java.util.List;

public interface IPFuenteFutService {
    public List<PFuenteFut> findAll();

    public PFuenteFut findById(PFuenteFutPK pFuenteFutPK);

    public PFuenteFut save(PFuenteFut pFuenteFut);

    public void deleteById(PFuenteFutPK pFuenteFutPK);
}
