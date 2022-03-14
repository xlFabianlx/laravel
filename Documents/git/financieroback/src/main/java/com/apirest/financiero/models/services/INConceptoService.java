package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NConcepto;

import java.util.List;

public interface INConceptoService {

	public List <NConcepto> findAll();


	public NConcepto findById(Short id);

	public NConcepto save(NConcepto concepto);

	public void  deleteById(Short id);

}
