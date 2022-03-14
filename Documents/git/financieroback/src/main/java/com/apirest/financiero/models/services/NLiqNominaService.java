package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NLiqNominaDao;
import com.apirest.financiero.models.entity.NLiqNomina;
import com.apirest.financiero.models.entity.NLiqNominaPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NLiqNominaService implements INLiqNominaService {

	@Autowired
	private NLiqNominaDao nLiqNominaDao;

	@Override
	public List <NLiqNomina> findAll() {
		return nLiqNominaDao.findAll();
	}

	@Override
	public NLiqNomina findById(NLiqNominaPK nLiqNominaPK) {
		return nLiqNominaDao.findById(nLiqNominaPK).orElse(null);
	}

	@Override
	public NLiqNomina save(NLiqNomina nLiqNomina) {
		return nLiqNominaDao.save(nLiqNomina);
	}

	@Override
	public void deleteById(NLiqNominaPK nLiqNominaPK) {
		nLiqNominaDao.deleteById(nLiqNominaPK);
	}
}
