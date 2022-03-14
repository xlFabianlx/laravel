package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NTipoLiquidacion;
import java.util.List;

public interface INTipoLiquidacionService {
  
  public List<NTipoLiquidacion> findAll();

  public NTipoLiquidacion findById(Short id);

  public NTipoLiquidacion save(NTipoLiquidacion nTipoLiq);

  public void  delete(Short id);
}
