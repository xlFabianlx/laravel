package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PRubroPtalIngreso;
import com.apirest.financiero.models.entity.PRubroPtalIngresoPK;

import java.util.List;

public interface IPRubroPtalIngresoService {
    List<PRubroPtalIngreso> findAll();

    PRubroPtalIngreso findById(PRubroPtalIngresoPK pRubroPtalIngresoPK);

    PRubroPtalIngreso save(PRubroPtalIngreso pRubroPtalIngreso);

    void deleteById(PRubroPtalIngresoPK pRubroPtalIngresoPK);
}
