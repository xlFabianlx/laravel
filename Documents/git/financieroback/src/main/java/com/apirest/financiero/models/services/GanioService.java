package com.apirest.financiero.models.services;
import java.util.List;

import com.apirest.financiero.models.dao.IGanioDao;
import com.apirest.financiero.models.entity.Ganio;
import com.apirest.financiero.models.entity.GanioPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GanioService {
    @Autowired
    private IGanioDao iGanoDao;

	public List<Ganio> findAll() {
		return iGanoDao.findAll();
	}

	public Ganio findById(GanioPK ganioPK) {
		return iGanoDao.findById(ganioPK).orElse(null);
	}

	public Ganio save(Ganio ganio) {
		return iGanoDao.save(ganio);
	}

   
}