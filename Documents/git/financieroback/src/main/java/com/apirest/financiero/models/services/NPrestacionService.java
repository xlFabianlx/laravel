package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NPrestacionDao;
import com.apirest.financiero.models.entity.NPrestacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NPrestacionService implements INPrestacionService {

	@Autowired
	private NPrestacionDao prestacionDao;

	@Override
	public List <NPrestacion> findAll() {
		return prestacionDao.findAll();
	}

	@Override
	public NPrestacion findById(String codConcepto) {
		return prestacionDao.findById(codConcepto).orElse(null);
	}

	@Override
	public NPrestacion save(NPrestacion prestacion) {
		return prestacionDao.save(prestacion);
	}

	@Override
	public void deleteById(String codConcepto) {
		prestacionDao.deleteById(codConcepto);
	}
}
