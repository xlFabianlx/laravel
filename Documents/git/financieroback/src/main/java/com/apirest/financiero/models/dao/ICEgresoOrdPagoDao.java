package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CEgresoOrdPago;
import com.apirest.financiero.models.entity.CEgresoOrdPagoPK;

public interface ICEgresoOrdPagoDao extends JpaRepository<CEgresoOrdPago, CEgresoOrdPagoPK> {
    
}