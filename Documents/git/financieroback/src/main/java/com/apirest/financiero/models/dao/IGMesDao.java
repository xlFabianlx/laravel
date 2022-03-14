package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GMes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGMesDao extends JpaRepository<GMes, Short>{
    
}