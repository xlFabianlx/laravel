package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.financiero.models.entity.NEncargo;

public interface NEncargoDao extends JpaRepository<NEncargo, Integer>{
    
}
