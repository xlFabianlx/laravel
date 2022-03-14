package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GDpto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGDptoDao extends JpaRepository<GDpto, Short>{
    
}