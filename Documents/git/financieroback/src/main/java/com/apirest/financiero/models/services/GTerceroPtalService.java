package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGTerceroPtalDao;
import com.apirest.financiero.models.entity.GTerceroPtal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GTerceroPtalService {

    @Autowired
    private IGTerceroPtalDao iGTerceroPtalDao;

	public List<GTerceroPtal> findAll() {
		return iGTerceroPtalDao.findAll();
	}

	public GTerceroPtal findById(Long id) {
		return iGTerceroPtalDao.findById(id).orElse(null);
	}

	public GTerceroPtal findByTerCod(Long terCod) {
		return iGTerceroPtalDao.findByTerCod(terCod);
	}

	public GTerceroPtal save(GTerceroPtal gTerceroPtal) {
		return iGTerceroPtalDao.save(gTerceroPtal);
	}
}