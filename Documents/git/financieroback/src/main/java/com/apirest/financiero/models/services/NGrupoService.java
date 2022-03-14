package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NGrupoDao;
import com.apirest.financiero.models.entity.NGrupo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NGrupoService implements INGrupoService {

  @Autowired
  private NGrupoDao nGrupoDao;

  @Override
  public List<NGrupo> findAll() {
    return nGrupoDao.findAll();
  }

  @Override
  public NGrupo findById(String id) {
    return nGrupoDao.findById(id).orElse(null);
  }

  @Override
  public NGrupo save(NGrupo nGrupo) {
    return nGrupoDao.save(nGrupo);
  }

  @Override
  public void deleteById(String id) {
    nGrupoDao.deleteById(id);
  }

}
