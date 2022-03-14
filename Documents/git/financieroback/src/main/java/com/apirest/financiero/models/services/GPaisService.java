package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGPaisDao;
import com.apirest.financiero.models.entity.GPais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPaisService {

    @Autowired
    private IGPaisDao iGPaisDao;

	public List<GPais> findAll() {
		return iGPaisDao.findAll();
	}

	public GPais findById(Short id) {
		return iGPaisDao.findById(id).orElse(null);
	}

	public GPais save(GPais gPais) {
		return iGPaisDao.save(gPais);
	}
}