package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NTipoLiquidacionDao;
import com.apirest.financiero.models.entity.NTipoLiquidacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NTipoLiquidacionService implements INTipoLiquidacionService{

  @Autowired
  private NTipoLiquidacionDao nTipoLiqDao;
  
  
  @Override
  public List<NTipoLiquidacion> findAll() {
    return nTipoLiqDao.findAll();
  }

  @Override
  public NTipoLiquidacion findById(Short id) {
    return nTipoLiqDao.findById(id).orElse(null);
  }

  @Override
  public NTipoLiquidacion save(NTipoLiquidacion nTipoLiq) {
    return nTipoLiqDao.save(nTipoLiq);
  }

  @Override
  public void delete(Short id) {
    nTipoLiqDao.deleteById(id);
  }
    
}
