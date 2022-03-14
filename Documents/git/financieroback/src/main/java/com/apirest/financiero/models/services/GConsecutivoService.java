package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGConsecutivoDao;
import com.apirest.financiero.models.entity.GConsecutivo;
import com.apirest.financiero.models.entity.GConsecutivoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GConsecutivoService {

    @Autowired
    private IGConsecutivoDao iGConsecutivoDao;

	public List<GConsecutivo> findAll() {
		return iGConsecutivoDao.findAll();
	}

	public GConsecutivo findById(GConsecutivoPK gConsecutivoPK) {
		return iGConsecutivoDao.findById(gConsecutivoPK).orElse(null);
	}

	public GConsecutivo save(GConsecutivo gConsecutivo) {
		return iGConsecutivoDao.save(gConsecutivo);
	}
}