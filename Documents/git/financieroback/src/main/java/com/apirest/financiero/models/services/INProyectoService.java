package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NProyecto;
import java.util.List;

public interface INProyectoService {
  
  public List<NProyecto> findAll();
  
  public NProyecto findById(Short id);

  public NProyecto save(NProyecto nProyecto);

  public void  delete(Short id);
}
