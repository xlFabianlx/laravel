package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGFuncionarioDao;
import com.apirest.financiero.models.entity.GFuncionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GFuncionarioService {

    @Autowired
    private IGFuncionarioDao iGFuncionarioDao;

	public List<GFuncionario> findAll() {
		return iGFuncionarioDao.findAll();
	}

	public GFuncionario findById(String id) {
		return iGFuncionarioDao.findById(id).orElse(null);
	}

	public GFuncionario save(GFuncionario gFuncionario) {
		return iGFuncionarioDao.save(gFuncionario);
	}
    
}