package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NPrestacion;

import java.util.List;

public interface INPrestacionService {
	public List<NPrestacion> findAll();

	public NPrestacion findById(String codConcepto);

	public NPrestacion save(NPrestacion prestacion);

	public void deleteById(String codConcepto);
}
