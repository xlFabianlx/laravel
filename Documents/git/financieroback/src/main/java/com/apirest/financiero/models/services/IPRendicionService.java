package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PRendicion;


import java.util.List;

public interface IPRendicionService {
    List<PRendicion> findAll();

    PRendicion findById(Short perRendCod);

    PRendicion save(PRendicion pRendicion);

    void deleteById(Short perRendCod);
}
