package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGMesDao;
import com.apirest.financiero.models.entity.GMes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GMesService {

    @Autowired
    private IGMesDao iGMesDao;

	public List<GMes> findAll() {
		return iGMesDao.findAll();
	}

	public GMes findById(Short id) {
		return iGMesDao.findById(id).orElse(null);
	}

	public GMes save(GMes gMes) {
		return iGMesDao.save(gMes);
	}
    
}