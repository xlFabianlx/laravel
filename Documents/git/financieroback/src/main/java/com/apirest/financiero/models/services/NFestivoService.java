package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NFestivoDao;
import com.apirest.financiero.models.entity.NFestivo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NFestivoService implements INFestivoService {

  @Autowired
  private NFestivoDao nFestivoDao;

  @Override
  public List<NFestivo> findAll() {
    return nFestivoDao.findAll();
  }

  @Override
  public NFestivo findById(Integer id) {
    return nFestivoDao.findById(id).orElse(null);
  }

  @Override
  public NFestivo save(NFestivo nFestivo) {
    return nFestivoDao.save(nFestivo);
  }

  @Override
  public void deleteById(Integer id) {
    nFestivoDao.deleteById(id);
  }

}
