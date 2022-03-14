package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GEmpresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGEmpresaDao extends JpaRepository<GEmpresa, Long>{
    
}