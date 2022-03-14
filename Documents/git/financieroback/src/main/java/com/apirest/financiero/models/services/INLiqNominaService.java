package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NLiqNomina;
import com.apirest.financiero.models.entity.NLiqNominaPK;

import java.util.List;

public interface INLiqNominaService {
	public List <NLiqNomina> findAll();

	public NLiqNomina findById(NLiqNominaPK nLiqNominaPK);

	public NLiqNomina save(NLiqNomina nLiqNomina);

	public void deleteById(NLiqNominaPK nLiqNominaPK);
}
