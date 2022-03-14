package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGEntidadDao;
import com.apirest.financiero.models.entity.GEntidad;
import com.apirest.financiero.models.entity.GEntidadPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GEntidadService {

    @Autowired
    private IGEntidadDao iGEntidadDao;

	public List<GEntidad> findAll() {
		return iGEntidadDao.findAll();
	}

	public GEntidad findById(GEntidadPK gEntidadPK) {
		return iGEntidadDao.findById(gEntidadPK).orElse(null);
	}

	public GEntidad save(GEntidad gEntidad) {
		return iGEntidadDao.save(gEntidad);
	}
}