package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.POrdenPago;
import com.apirest.financiero.models.entity.POrdenPagoPK;

import java.util.List;

public interface IPOrdenPagoService {
    List<POrdenPago> findAll();

    POrdenPago findById(POrdenPagoPK pOrdenPagoPK);

    POrdenPago save(POrdenPago pOrdenPago);

    void deleteById(POrdenPagoPK pOrdenPagoPK);

    List<POrdenPago> finOrdenesPagoWithoutEgreso();
}
