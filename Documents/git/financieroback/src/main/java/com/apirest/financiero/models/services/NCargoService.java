package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NCargoDao;
import com.apirest.financiero.models.entity.NCargo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NCargoService implements INCargoService{

  @Autowired
  private NCargoDao nCargoDao;

  @Override
  public List<NCargo> findAll() {
    return nCargoDao.findAll();
  }

  @Override
  public NCargo findById(Integer id) {
    return nCargoDao.findById(id).orElse(null);
  }

  @Override
  public NCargo save(NCargo nCargo) {
    return nCargoDao.save(nCargo);
  }

  @Override
  public void deleteById(Integer id) {
    nCargoDao.deleteById(id);
  }  
}
