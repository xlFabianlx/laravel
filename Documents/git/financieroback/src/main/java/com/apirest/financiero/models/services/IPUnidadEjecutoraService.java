package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.Punidadejecutora;

import java.util.List;

public interface IPUnidadEjecutoraService {
    List<Punidadejecutora> findAll();

    Punidadejecutora findById(Short UniEje);

    Punidadejecutora save(Punidadejecutora punidadejecutora);

    void deleteById(Short UniEje);
}
