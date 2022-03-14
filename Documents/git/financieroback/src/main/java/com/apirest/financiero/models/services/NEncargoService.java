package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NEncargoDao;
import com.apirest.financiero.models.entity.NEncargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NEncargoService implements  INEncargoService{

	@Autowired
	private NEncargoDao encargoDao;

	@Override
	public List <NEncargo> findAll() {
		return encargoDao.findAll();
	}

	@Override
	public NEncargo findById(Integer idencargo) {
		return encargoDao.findById(idencargo).orElse(null);
	}

	@Override
	@Transactional
	public NEncargo save(NEncargo nEncargo) {
		return encargoDao.save(nEncargo);
	}

	@Override
	public void deleteById(Integer idencargo) {
		encargoDao.deleteById(idencargo);
	}
}
