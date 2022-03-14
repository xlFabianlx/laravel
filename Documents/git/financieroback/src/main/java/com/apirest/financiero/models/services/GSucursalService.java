package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.IGSucursalDao;
import com.apirest.financiero.models.entity.GSucursal;
import com.apirest.financiero.models.entity.GSucursalPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GSucursalService {

    @Autowired
    private IGSucursalDao iGSucursalDao;

	public List<GSucursal> findAll() {
        return iGSucursalDao.findAll();
	}

	public GSucursal findById(GSucursalPK gSucursalpPk) {
		return iGSucursalDao.findById(gSucursalpPk).orElse(null);
	}

	public GSucursal save(GSucursal gSucursal) {
		return iGSucursalDao.save(gSucursal);
	}
}