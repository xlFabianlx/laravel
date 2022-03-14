package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GPais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGPaisDao extends JpaRepository<GPais, Short>{
    
}