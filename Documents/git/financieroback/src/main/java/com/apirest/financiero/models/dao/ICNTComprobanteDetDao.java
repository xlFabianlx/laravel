package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.CNTComprobanteDet;
import com.apirest.financiero.models.entity.CNTComprobanteDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICNTComprobanteDetDao extends JpaRepository<CNTComprobanteDet, CNTComprobanteDetPK> {
    
}
  