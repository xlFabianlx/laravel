package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NProyectoDao;
import com.apirest.financiero.models.entity.NProyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NProyectoService implements INProyectoService{

  @Autowired
  private NProyectoDao nProyectoDao;
  
  @Override
  public List<NProyecto> findAll() {
    return nProyectoDao.findAll();
  }

  @Override
  public NProyecto findById(Short id) {
    return nProyectoDao.findById(id).orElse(null);
  }

  @Override
  public NProyecto save(NProyecto nProyecto) {
    return nProyectoDao.save(nProyecto);
  }

  @Override
  public void delete(Short id) {
    nProyectoDao.deleteById(id);
  }
    
}
