package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PptoIng;
import com.apirest.financiero.models.entity.PptoIngPK;

import java.util.List;

public interface IPptoIngService {
    List<PptoIng> findAll();

    PptoIng findById(PptoIngPK pptoIngPK);

    PptoIng save(PptoIng pptoIng);

    void deleteById(PptoIngPK pptoIngPK);
}
