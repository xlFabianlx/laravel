package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NConceptoGrupoDao;
import com.apirest.financiero.models.entity.NConceptoGrupo;
import com.apirest.financiero.models.entity.NConceptoGrupoPK;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NConceptoGrupoService implements INConceptoGrupoService {

  @Autowired
  private NConceptoGrupoDao nConceptoGrupoDao;

  @Override
  @Transactional(readOnly = true)
  public List<NConceptoGrupo> findAll() {
    return nConceptoGrupoDao.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public NConceptoGrupo findById(NConceptoGrupoPK nConceptoGrupoPK) {
    return nConceptoGrupoDao.findById(nConceptoGrupoPK).orElse(null);
  }

  public NConceptoGrupo saveConcepto(NConceptoGrupo nConceptoGrupo) {
    return nConceptoGrupoDao.save(nConceptoGrupo);
  }

  @Override
  public NConceptoGrupo save(NConceptoGrupo nConceptoGrupo) {
    return nConceptoGrupoDao.save(nConceptoGrupo);
  }

  @Override
  public void deleteById(NConceptoGrupoPK id) {
    nConceptoGrupoDao.deleteById(id);
  }

}
