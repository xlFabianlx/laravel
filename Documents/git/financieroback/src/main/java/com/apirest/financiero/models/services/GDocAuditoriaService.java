package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGDocAuditoriaDao;
import com.apirest.financiero.models.entity.GDocAuditoria;
import com.apirest.financiero.models.entity.GDocAuditoriaPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GDocAuditoriaService {

    @Autowired
    private IGDocAuditoriaDao iGDocAuditoriaDao;

	public List<GDocAuditoria> findAll() {
		return iGDocAuditoriaDao.findAll();
	}

	public GDocAuditoria findById(GDocAuditoriaPK gDocAuditoriaPK) {
		return iGDocAuditoriaDao.findById(gDocAuditoriaPK).orElse(null);
	}

	public GDocAuditoria save(GDocAuditoria gDocAuditoria) {
		return iGDocAuditoriaDao.save(gDocAuditoria);
	}
}