package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NNovedadDao;
import com.apirest.financiero.models.entity.NNovedad;
import com.apirest.financiero.models.entity.NNovedadPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NNovedadService implements INNovedadService{

	@Autowired
	private NNovedadDao novedadDao;

	@Override
	public List <NNovedad> findAll() {
		return novedadDao.findAll();
	}

	@Override
	public NNovedad findById(NNovedadPK novedadPK) {
		return novedadDao.findById(novedadPK).orElse(null);
	}

	@Override
	public NNovedad save(NNovedad novedad) {
		return novedadDao.save(novedad);
	}

	@Override
	public void deleteById(NNovedadPK novedadPK) {
		novedadDao.deleteById(novedadPK);
	}
}
