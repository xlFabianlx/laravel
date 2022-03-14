package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGDocOficialDao;
import com.apirest.financiero.models.entity.GDocOficial;
import com.apirest.financiero.models.entity.GDocOficialPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GDocOficialService {
    
    @Autowired
    private IGDocOficialDao iGDocOficialDao;

	public List<GDocOficial> findAll() {
		return iGDocOficialDao.findAll();
	}

	public GDocOficial findById(GDocOficialPK gDocOficialPK) {
		return iGDocOficialDao.findById(gDocOficialPK).orElse(null);
	}

	public GDocOficial save(GDocOficial gDocOficial) {
		return iGDocOficialDao.save(gDocOficial);
	}
}