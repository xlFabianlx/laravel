package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GFirmantes;
import com.apirest.financiero.models.entity.GFirmantesPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGFirmantesDao extends JpaRepository<GFirmantes, GFirmantesPK>{
    
}