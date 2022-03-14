package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NTipoNomina;
import java.util.List;

public interface INTipoNominaService {
  
  public List<NTipoNomina> findAll();

  public NTipoNomina findById(Short id);

  public NTipoNomina save(NTipoNomina nTipoNom);

  public void  delete(Short id);
}
