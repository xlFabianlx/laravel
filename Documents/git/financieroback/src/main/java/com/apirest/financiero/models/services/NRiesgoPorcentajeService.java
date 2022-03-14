package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NRiesgoPorcentajeDao;
import com.apirest.financiero.models.entity.NRiesgoPorcentaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NRiesgoPorcentajeService implements INRiesgoPorcentajeService{

  @Autowired
  private NRiesgoPorcentajeDao nRiesgoPorcentajeDao;  
  
  @Override
  public List<NRiesgoPorcentaje> findAll() {
    return nRiesgoPorcentajeDao.findAll();
  }

  @Override
  public NRiesgoPorcentaje findById(Short id) {
    return nRiesgoPorcentajeDao.findById(id).orElse(null);
  }

  @Override
  public NRiesgoPorcentaje save(NRiesgoPorcentaje nRiesgoPorcentaje) {
    return nRiesgoPorcentajeDao.save(nRiesgoPorcentaje);
  }

  @Override
  public void delete(Short id) {
    nRiesgoPorcentajeDao.deleteById(id);
  }
    
}
