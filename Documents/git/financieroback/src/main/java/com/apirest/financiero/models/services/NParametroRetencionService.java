package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NParametroRetencionDao;
import com.apirest.financiero.models.entity.NParametroRetencion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NParametroRetencionService implements INParametroRetencionService{

  @Autowired
  private NParametroRetencionDao nParametroRetencionDao;
  
  @Override
  public List<NParametroRetencion> findAll() {
    return nParametroRetencionDao.findAll();
  }

  @Override
  public NParametroRetencion findById(Integer id) {
    return nParametroRetencionDao.findById(id).orElse(null);
  }

  @Override
  public NParametroRetencion save(NParametroRetencion nParametroretencion) {
    return nParametroRetencionDao.save(nParametroretencion);
  }

  @Override
  public void deleteById(Integer id) {
    nParametroRetencionDao.deleteById(id);
  }
    
}
