package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGDependenciaDao;
import com.apirest.financiero.models.entity.GDependencia; 
import com.apirest.financiero.models.entity.GDependenciaPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GDependenciaService {

    @Autowired
	public IGDependenciaDao iGDependenciaDao;

	public List<GDependencia> findAll() {
		return iGDependenciaDao.findAll();
	}

	public GDependencia findById(GDependenciaPK gDependenciaPK) {
		return iGDependenciaDao.findById(gDependenciaPK).orElse(null);
	}

	public GDependencia save(GDependencia gDependencia) {
		return iGDependenciaDao.save(gDependencia);
	}

	public Long findConsecutivo(){
		return iGDependenciaDao.findConsecutivo();
	}

	public void delete(GDependenciaPK id) {
        iGDependenciaDao.deleteById(id);
    }

}