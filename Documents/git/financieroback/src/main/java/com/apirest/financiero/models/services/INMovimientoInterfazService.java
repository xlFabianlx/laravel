package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NMovimientoInterfaz;
import com.apirest.financiero.models.entity.NMovimientoInterfazPK;

import java.util.List;

public interface INMovimientoInterfazService {
	public List <NMovimientoInterfaz> findAll();

	public NMovimientoInterfaz findById(NMovimientoInterfazPK nMovIntPk);

	public NMovimientoInterfaz save(NMovimientoInterfaz nMovInt);

	public void deleteById(NMovimientoInterfazPK nMovIntPk);
}
