package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NEmpleado;
import com.apirest.financiero.models.entity.NEmpleadoPK;
import java.util.List;

public interface INEmpleadoService {
    public List<NEmpleado> findAll();
		
	public NEmpleado findById(NEmpleadoPK nEmpleadoPK);
	
	public NEmpleado save(NEmpleado nEmpleado);
	
	public void  deleteById(NEmpleadoPK nEmpleadoPK);
}
