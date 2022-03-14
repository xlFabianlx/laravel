package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGProyectoDao;
import com.apirest.financiero.models.entity.GProyecto;
import com.apirest.financiero.models.entity.GProyectoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GProyectoService {

    @Autowired
    private IGProyectoDao iGProyectoDao;

	public List<GProyecto> findAll() {
		return iGProyectoDao.findAll();
	}

	public Long findConsecutivo(){
		return iGProyectoDao.findConsecutivo();
	}

	public GProyecto findById(GProyectoPK gProyectopPk) {
		return iGProyectoDao.findById(gProyectopPk).orElse(null);
	}

	public GProyecto findProyectoId(Long proyCod){
		return iGProyectoDao.findProyectoId(proyCod);
	}

	public GProyecto save(GProyecto gProyecto) {
		return iGProyectoDao.save(gProyecto);
	}

	public List<GProyecto> findAllProyecto(){
		return iGProyectoDao.findAllProyecto();
	}
}