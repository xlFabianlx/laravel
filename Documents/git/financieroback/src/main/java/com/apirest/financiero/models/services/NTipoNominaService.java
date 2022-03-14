package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NTipoNominaDao;
import com.apirest.financiero.models.entity.NTipoNomina;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NTipoNominaService implements INTipoNominaService{
    
  @Autowired
  private NTipoNominaDao nTipoNomDao;

  @Override
  public List<NTipoNomina> findAll() {
    return nTipoNomDao.findAll();
  }

  @Override
  public NTipoNomina findById(Short id) {
    return nTipoNomDao.findById(id).orElse(null);
  }

  @Override
  public NTipoNomina save(NTipoNomina nTipoNom) {
    return nTipoNomDao.save(nTipoNom);
  }

  @Override
  public void delete(Short id) {
    nTipoNomDao.deleteById(id);
  }
  
}
