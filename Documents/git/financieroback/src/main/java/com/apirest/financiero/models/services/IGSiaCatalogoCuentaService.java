package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.GSiaCatalogoCuenta;
import com.apirest.financiero.models.entity.GSiaCatalogoCuentaPK;
import java.util.List;


public interface IGSiaCatalogoCuentaService {
 
    public List<GSiaCatalogoCuenta> findAll();

    public GSiaCatalogoCuenta findById(GSiaCatalogoCuentaPK siacatcuentPk);

    public GSiaCatalogoCuenta save(GSiaCatalogoCuenta gsiacatcuent);

    public void deleteById(GSiaCatalogoCuentaPK siacatcuentPk);
    
}
