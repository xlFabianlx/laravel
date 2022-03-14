package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.NParafiscales;
import com.apirest.financiero.models.entity.NParafiscalesPK;
import java.util.List;

public interface INParafiscalService {
    public List<NParafiscales> findAll();

    public NParafiscales findById(NParafiscalesPK id);

    public NParafiscales save(NParafiscales nParaFiscales);

    public void deleteById(NParafiscalesPK id);
}
