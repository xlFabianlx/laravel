package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGAreaDao;
import com.apirest.financiero.models.entity.GArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GAreaService {

    @Autowired
    private IGAreaDao iGAreaDao;

	public List<GArea> findAll() {
		return iGAreaDao.findAll();
	}

	public GArea findById(short id) {
		return iGAreaDao.findById(id).orElse(null);
	}

	public GArea save(GArea gArea) {
		return iGAreaDao.save(gArea);
	}
}

