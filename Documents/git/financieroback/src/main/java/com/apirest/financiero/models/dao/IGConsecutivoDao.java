package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GConsecutivo;
import com.apirest.financiero.models.entity.GConsecutivoPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGConsecutivoDao extends JpaRepository<GConsecutivo, GConsecutivoPK>{
    
}