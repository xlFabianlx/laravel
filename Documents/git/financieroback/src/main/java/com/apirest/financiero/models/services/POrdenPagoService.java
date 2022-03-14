package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPOrdenPagoDao;
import com.apirest.financiero.models.entity.POrdenPago;
import com.apirest.financiero.models.entity.POrdenPagoPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class POrdenPagoService implements IPOrdenPagoService {
    @Autowired
    private IPOrdenPagoDao iPOrdenPagoDao;

    @Override
    public List<POrdenPago> findAll() {
        return iPOrdenPagoDao.findAll();
    }

    @Override
    public POrdenPago findById(POrdenPagoPK pOrdenPagoPK) {
        return iPOrdenPagoDao.findById(pOrdenPagoPK).orElse(null);
    }

    @Override
    public POrdenPago save(POrdenPago pOrdenPago) {
        return iPOrdenPagoDao.save(pOrdenPago);
    }

    @Override
    public void deleteById(POrdenPagoPK pOrdenPagoPK) {
        iPOrdenPagoDao.deleteById(pOrdenPagoPK);
    }

    @Override
    public List<POrdenPago> finOrdenesPagoWithoutEgreso() { return iPOrdenPagoDao.finOrdenesPagoWithoutEgreso(); }
}
