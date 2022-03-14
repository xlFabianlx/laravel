package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.CconceptIngDet;
import com.apirest.financiero.models.entity.CconceptIngDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICconceptIngDetDao extends JpaRepository<CconceptIngDet, CconceptIngDetPK>{
    
}