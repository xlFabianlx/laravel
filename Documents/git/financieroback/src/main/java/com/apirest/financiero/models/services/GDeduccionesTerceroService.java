package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.GDeduccionesTerceroDao;
import com.apirest.financiero.models.entity.GDeduccionesTercero;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class GDeduccionesTerceroService {

  @Autowired
  private GDeduccionesTerceroDao dao;

  public List<GDeduccionesTercero> findAll() {
    return dao.findAll();
  }

  public List<GDeduccionesTercero> findByTercero(long idTercero) {
    return dao.findByTercero(idTercero);
  }

  @Transactional
  public void deleteByTercero(Long idTercero) {
    dao.deleteIdTercero(idTercero);
  }

  public List<GDeduccionesTercero> saveAllGdeduccionesTercero(
    List<GDeduccionesTercero> data
  ) {
    
    System.out.println(data);
    List<GDeduccionesTercero> response = (List<GDeduccionesTercero>) dao.saveAll(
      data
    );
    return response;
  }
}
