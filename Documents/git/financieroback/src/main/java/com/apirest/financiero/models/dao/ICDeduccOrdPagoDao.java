package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CDeduccOrdPago;
import com.apirest.financiero.models.entity.CDeduccOrdPagoPK;

public interface ICDeduccOrdPagoDao extends JpaRepository<CDeduccOrdPago, CDeduccOrdPagoPK> {
    
}