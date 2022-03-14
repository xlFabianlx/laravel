package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NRiesgoPorcentaje;
import java.util.List;

public interface INRiesgoPorcentajeService {
  
  public List<NRiesgoPorcentaje> findAll();
  
  public NRiesgoPorcentaje findById(Short id);

  public NRiesgoPorcentaje save(NRiesgoPorcentaje nRiesgoPorcentaje);

  public void  delete(Short id);
}
