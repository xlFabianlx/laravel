package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NGrupo;
import java.util.List;

public interface INGrupoService {

    public List<NGrupo> findAll();

    public NGrupo findById(String id);

    public NGrupo save(NGrupo nGrupo);

    public void deleteById(String id);

}
