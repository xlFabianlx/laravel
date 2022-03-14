package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NCargo;
import java.util.List;

public interface INCargoService {

  public List<NCargo> findAll();

  public NCargo findById(Integer id);

  public NCargo save(NCargo nCargo);

  public void deleteById(Integer id);
}
