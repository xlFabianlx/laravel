package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NEncargo;

import java.util.List;

public interface INEncargoService {
	public List <NEncargo> findAll();

	public NEncargo findById(Integer idencargo);

	public NEncargo save(NEncargo nEncargo);

	public void deleteById(Integer idencargo);
}
