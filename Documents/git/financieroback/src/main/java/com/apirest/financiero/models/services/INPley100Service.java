package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NPLey100;

import java.util.List;

public interface INPley100Service {
	public List<NPLey100> findAll();

	public NPLey100 findById(Integer id);

	public NPLey100 save(NPLey100 ley100);

	public void deleteById(Integer id);
}
