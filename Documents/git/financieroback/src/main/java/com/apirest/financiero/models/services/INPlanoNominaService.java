package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NPlanoNomina;
import com.apirest.financiero.models.entity.NPlanoNominaPK;

import java.util.List;

public interface INPlanoNominaService {
	public List<NPlanoNomina> findAll();

	public NPlanoNomina findById(NPlanoNominaPK planoNominaPK);

	public NPlanoNomina save(NPlanoNomina planoNomina);

	public void deleteById(NPlanoNominaPK planoNominaPK);
}
