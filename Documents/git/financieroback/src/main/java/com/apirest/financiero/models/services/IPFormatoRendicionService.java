package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PFormatoRendicion;
import com.apirest.financiero.models.entity.PFormatoRendicionPK;

import java.util.List;

public interface IPFormatoRendicionService {
    public List<PFormatoRendicion> findAll();

    public PFormatoRendicion findById(PFormatoRendicionPK pFormatoRendicionPK);

    public PFormatoRendicion save(PFormatoRendicion pFormatoRendicion);

    public void deleteById(PFormatoRendicionPK pFormatoRendicionPK);
}
