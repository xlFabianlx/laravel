package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGEmpresaDao;
import com.apirest.financiero.models.entity.GEmpresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GEmpresaService {

    @Autowired
    private  IGEmpresaDao iGEmpresaDao;

	public List<GEmpresa> findAll() {
		return iGEmpresaDao.findAll();
	}

	public GEmpresa findById(Long id) {
		return iGEmpresaDao.findById(id).orElse(null);
	}

	public GEmpresa save(GEmpresa gEmpresa) {
		return iGEmpresaDao.save(gEmpresa);
	}

	public void delete(Long id) {
		iGEmpresaDao.deleteById(id);
	}
}