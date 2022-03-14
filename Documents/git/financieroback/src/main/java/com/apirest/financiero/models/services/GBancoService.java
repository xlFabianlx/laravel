package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGBancoDao;
import com.apirest.financiero.models.entity.GBanco;
import com.apirest.financiero.models.entity.GBancoPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GBancoService {

    @Autowired
    private IGBancoDao iGBancoDao;

	public List<GBanco> findAll() {
		return iGBancoDao.findAll();
    }
    
    public GBanco findById(GBancoPK gBancoPK) {
		return iGBancoDao.findById(gBancoPK).orElse(null);
	}

	public GBanco save(GBanco gArea) {
		return iGBancoDao.save(gArea);
	}

	public void delete(GBancoPK id) {
		iGBancoDao.deleteById(id);
	}
}

