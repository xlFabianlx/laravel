package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.GSiaCompromiso;
import com.apirest.financiero.models.entity.GSiaCompromisoPK;
import java.util.List;


public interface IGSiaCompromisoService {
    
    public List<GSiaCompromiso> findAll();

    public GSiaCompromiso findById(GSiaCompromisoPK siaCompromisoPk);

    public GSiaCompromiso save(GSiaCompromiso siaCompromiso);

    public void deleteById(GSiaCompromisoPK siaCompromisoPk);
}
