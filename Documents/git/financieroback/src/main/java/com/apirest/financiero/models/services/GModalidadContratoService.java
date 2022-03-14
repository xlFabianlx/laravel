package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGModalidadContratoDao;
import com.apirest.financiero.models.entity.GModalidadContrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GModalidadContratoService {

    @Autowired
    private IGModalidadContratoDao iGModalidadContratoDao;

	public List<GModalidadContrato> findAll() {
		return iGModalidadContratoDao.findAll();
	}

	public GModalidadContrato findById(Short id) {
		return iGModalidadContratoDao.findById(id).orElse(null);
	}

	public GModalidadContrato save(GModalidadContrato gModalidadContrato) {
		return iGModalidadContratoDao.save(gModalidadContrato);
	}
}