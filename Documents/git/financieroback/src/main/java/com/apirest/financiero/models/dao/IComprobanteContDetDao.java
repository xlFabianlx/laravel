package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.CComprobanteContDet;
import com.apirest.financiero.models.entity.CComprobanteContDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComprobanteContDetDao extends JpaRepository<CComprobanteContDet, CComprobanteContDetPK>{
    
}
 