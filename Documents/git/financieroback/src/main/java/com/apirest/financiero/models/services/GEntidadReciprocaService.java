package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGEntidadReciprocaDao;
import com.apirest.financiero.models.entity.GEntidadReciproca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GEntidadReciprocaService {

    @Autowired
    private IGEntidadReciprocaDao iGEntidadReciprocaDao;

	public List<GEntidadReciproca> findAll() {
		return iGEntidadReciprocaDao.findAll();
	}

	public GEntidadReciproca findById(String id) {
		return iGEntidadReciprocaDao.findById(id).orElse(null);
	}

	public GEntidadReciproca save(GEntidadReciproca gEntidadReciproca) {
		return iGEntidadReciprocaDao.save(gEntidadReciproca);
	}
}