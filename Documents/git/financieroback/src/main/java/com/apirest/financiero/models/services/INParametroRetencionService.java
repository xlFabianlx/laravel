package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NParametroRetencion;
import java.util.List;

public interface INParametroRetencionService {

  public List<NParametroRetencion> findAll();

  public NParametroRetencion findById(Integer id);

  public NParametroRetencion save(NParametroRetencion nParametroretencion);

  public void deleteById(Integer id);

}
