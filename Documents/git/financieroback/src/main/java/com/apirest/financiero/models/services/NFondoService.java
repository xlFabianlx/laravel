package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NFondoDao;
import com.apirest.financiero.models.entity.NFondo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NFondoService implements INFondoService {

  @Autowired
  private NFondoDao nFondoDao;

  @Override
  public List<NFondo> findAll() {
    return nFondoDao.findAll();
  }

  @Override
  public NFondo findById(Short id) {
    return nFondoDao.findById(id).orElse(null);
  }

  @Override
  public NFondo save(NFondo nFondo) {
    return nFondoDao.save(nFondo);
  }

  @Override
  public void deleteById(Short id) {
    nFondoDao.deleteById(id);
  }

}
