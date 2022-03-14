package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGFirmantesDao;
import com.apirest.financiero.models.entity.GFirmantes;
import com.apirest.financiero.models.entity.GFirmantesPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GFirmantesService {

    @Autowired
    private IGFirmantesDao iGFirmantesDao;

	public List<GFirmantes> findAll() {
		return iGFirmantesDao.findAll();
	}

	public GFirmantes findById(GFirmantesPK gFirmantesPK) {
		return iGFirmantesDao.findById(gFirmantesPK).orElse(null);
	}

	public GFirmantes save(GFirmantes gFirmantes) {
		return iGFirmantesDao.save(gFirmantes);
	}
}