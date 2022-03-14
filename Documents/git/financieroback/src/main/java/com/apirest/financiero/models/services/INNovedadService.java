package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NNovedad;
import com.apirest.financiero.models.entity.NNovedadPK;

import java.util.List;

public interface INNovedadService {
	public List<NNovedad> findAll();

	public NNovedad findById(NNovedadPK novedadPK);

	public NNovedad save(NNovedad novedad);

	public void deleteById(NNovedadPK novedadPK);
}
