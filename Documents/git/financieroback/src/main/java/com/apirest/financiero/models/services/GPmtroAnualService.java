package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGPmtroAnualDao;
import com.apirest.financiero.models.entity.GPmtroAnual;
import com.apirest.financiero.models.entity.GPmtroAnualPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPmtroAnualService {

    @Autowired
    private IGPmtroAnualDao iGPmtroAnualDao;

	public List<GPmtroAnual> findAll() {
		return iGPmtroAnualDao.findAll();
	}

	public GPmtroAnual findById(GPmtroAnualPK gPmtroAnualPK) {
		return iGPmtroAnualDao.findById(gPmtroAnualPK).orElse(null);
	}

	public GPmtroAnual save(GPmtroAnual gPmtroAnual) {
		return iGPmtroAnualDao.save(gPmtroAnual);
	}
}