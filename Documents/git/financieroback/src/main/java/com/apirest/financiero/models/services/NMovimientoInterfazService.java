package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NMovimientoInterfazDao;
import com.apirest.financiero.models.entity.NMovimientoInterfaz;
import com.apirest.financiero.models.entity.NMovimientoInterfazPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NMovimientoInterfazService implements INMovimientoInterfazService{

	@Autowired
	private NMovimientoInterfazDao nMovIntDao;

	@Override
	public List <NMovimientoInterfaz> findAll() {
		return nMovIntDao.findAll();
	}

	@Override
	public NMovimientoInterfaz findById(NMovimientoInterfazPK nMovIntPk) {
		return nMovIntDao.findById(nMovIntPk).orElse(null);
	}

	@Override
	public NMovimientoInterfaz save(NMovimientoInterfaz nMovInt) {
		return nMovIntDao.save(nMovInt);
	}

	@Override
	public void deleteById(NMovimientoInterfazPK nMovIntPk){
		nMovIntDao.deleteById(nMovIntPk);
	}
}
