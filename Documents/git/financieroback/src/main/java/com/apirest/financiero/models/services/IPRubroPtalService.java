package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PRubroPtal;
import com.apirest.financiero.models.entity.PRubroPtalPK;

import java.util.List;

public interface IPRubroPtalService {
    List<PRubroPtal> findAll();

    PRubroPtal findById(PRubroPtalPK pRubroPtalPK);

    PRubroPtal save(PRubroPtal pRubroPtal);

    void deleteById(PRubroPtalPK pRubroPtalPK);

    List<PRubroPtal> findAllRubrosConFuente();
}
