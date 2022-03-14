package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NConceptoGrupo;
import com.apirest.financiero.models.entity.NConceptoGrupoPK;
import java.util.List;

public interface INConceptoGrupoService {

    public List<NConceptoGrupo> findAll();

    public NConceptoGrupo findById(NConceptoGrupoPK id);

    public NConceptoGrupo save(NConceptoGrupo nConceptoGrupo);

    public void deleteById(NConceptoGrupoPK id);
}
