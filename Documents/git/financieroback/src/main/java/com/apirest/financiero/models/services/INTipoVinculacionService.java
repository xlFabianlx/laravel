package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NTipoVinculacion;
import java.util.List;

public interface INTipoVinculacionService {
  
  public List<NTipoVinculacion> findAll();

  public NTipoVinculacion findById(Integer id);

  public NTipoVinculacion save(NTipoVinculacion nTipoVinc);

  public void  delete(Integer id);
}
