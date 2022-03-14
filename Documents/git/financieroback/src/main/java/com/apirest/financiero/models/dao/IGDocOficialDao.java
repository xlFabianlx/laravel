package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GDocOficial;
import com.apirest.financiero.models.entity.GDocOficialPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGDocOficialDao extends JpaRepository<GDocOficial, GDocOficialPK>{
    
}