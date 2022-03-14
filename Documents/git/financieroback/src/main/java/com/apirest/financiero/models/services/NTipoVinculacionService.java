package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NTipoVinculacionDao;
import com.apirest.financiero.models.entity.NTipoVinculacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NTipoVinculacionService implements INTipoVinculacionService{
    
  @Autowired
  private NTipoVinculacionDao nTipoVincDao;
  
  @Override
  public List<NTipoVinculacion> findAll(){
    return nTipoVincDao.findAll();
  }

  @Override
  public NTipoVinculacion findById(Integer id) {
    return nTipoVincDao.findById(id).orElse(null);
  }

  @Override
  public NTipoVinculacion save(NTipoVinculacion nTipoVinc) {
    return nTipoVincDao.save(nTipoVinc);
  }

  @Override
  public void delete(Integer id) {
    nTipoVincDao.deleteById(id);
  }
  
  
  
  
}
