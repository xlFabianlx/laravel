package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGCiudadDao;
import com.apirest.financiero.models.entity.GCiudad;
import com.apirest.financiero.models.entity.GCiudadPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GCiudadService {

    @Autowired
    private IGCiudadDao iGCiudadDao;

	public List<GCiudad> findAll() {
		return iGCiudadDao.findAll();
	}

	public List<GCiudad> findByDptCod(Short DptCod) {
		return iGCiudadDao.findByDptCod(DptCod);
	}

	public GCiudad findById(GCiudadPK gCiudadPK) {
		return iGCiudadDao.findById(gCiudadPK).orElse(null);
	}

	public GCiudad save(GCiudad gCiudad) {
		return iGCiudadDao.save(gCiudad);
	}
}