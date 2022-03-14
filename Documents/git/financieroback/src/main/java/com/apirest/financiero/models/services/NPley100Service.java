package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NPley100Dao;
import com.apirest.financiero.models.entity.NPLey100;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NPley100Service implements INPley100Service {

	@Autowired
	private NPley100Dao ley100Dao;

	@Override
	public List <NPLey100> findAll() {
		return ley100Dao.findAll();
	}

	@Override
	public NPLey100 findById(Integer id) {
		return ley100Dao.findById(id).orElse(null);
	}

	@Override
	public NPLey100 save(NPLey100 ley100) {
		return ley100Dao.save(ley100);
	}

	@Override
	public void deleteById(Integer id) {
		ley100Dao.deleteById(id);
	}
}
