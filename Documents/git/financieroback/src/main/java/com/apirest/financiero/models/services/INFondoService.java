package com.apirest.financiero.models.services;

import java.util.List;
import com.apirest.financiero.models.entity.NFondo;

public interface INFondoService {
    
    public List<NFondo> findAll();	

    public NFondo findById(Short id);

    public NFondo save(NFondo nFondo);

    public void  deleteById(Short id);

}
