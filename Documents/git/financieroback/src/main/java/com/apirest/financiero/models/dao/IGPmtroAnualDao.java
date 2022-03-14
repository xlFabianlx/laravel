package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GPmtroAnual;
import com.apirest.financiero.models.entity.GPmtroAnualPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGPmtroAnualDao extends JpaRepository<GPmtroAnual,GPmtroAnualPK>{
    
}