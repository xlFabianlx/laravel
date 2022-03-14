package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGDptoDao;
import com.apirest.financiero.models.entity.GDpto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GDptoService {

    @Autowired
    private IGDptoDao iGDptoDao;

	public List<GDpto> findAll() {
		return iGDptoDao.findAll();
	}

	public GDpto findById(short id) {
		return iGDptoDao.findById(id).orElse(null);
	}

	public GDpto save(GDpto gDpto) {
		return iGDptoDao.save(gDpto);
	}
}