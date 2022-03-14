package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NPlanoNominaDao;
import com.apirest.financiero.models.entity.NPlanoNomina;
import com.apirest.financiero.models.entity.NPlanoNominaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NPlanoNominaService implements INPlanoNominaService{

	@Autowired
	private NPlanoNominaDao planoDao;

	@Override
	public List <NPlanoNomina> findAll() {
		return planoDao.findAll();
	}

	@Override
	public NPlanoNomina findById(NPlanoNominaPK planoNominaPK) {
		return planoDao.findById(planoNominaPK).orElse(null);
	}

	@Override
	public NPlanoNomina save(NPlanoNomina planoNomina) {
		return planoDao.save(planoNomina);
	}

	@Override
	public void deleteById(NPlanoNominaPK planoNominaPK) {
		planoDao.deleteById(planoNominaPK);
	}
}
