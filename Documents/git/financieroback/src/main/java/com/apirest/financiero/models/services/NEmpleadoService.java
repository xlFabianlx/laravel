package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NEmpleadoDao;
import com.apirest.financiero.models.entity.NEmpleado;
import com.apirest.financiero.models.entity.NEmpleadoPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NEmpleadoService implements INEmpleadoService {

  @Autowired
  private NEmpleadoDao nEmpleadoDao;
  
  @Override
  public List<NEmpleado> findAll() {
    return nEmpleadoDao.findAll();
  }

  @Override
  public NEmpleado findById(NEmpleadoPK nEmpleadoPK) {
    return nEmpleadoDao.findById(nEmpleadoPK).orElse(null);
  }

  @Override
  public NEmpleado save(NEmpleado nEmpleado) {
    return nEmpleadoDao.save(nEmpleado);
  }

  @Override
  public void deleteById(NEmpleadoPK nEmpleadoPK) {
    nEmpleadoDao.deleteById(nEmpleadoPK);
  }
    
}
