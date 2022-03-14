package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.CconceptIngEnc;
import com.apirest.financiero.models.entity.CconceptIngEncPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICconceptIngEncDao extends JpaRepository<CconceptIngEnc, CconceptIngEncPK> {
    
}