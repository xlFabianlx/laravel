package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GEntidad;
import com.apirest.financiero.models.entity.GEntidadPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGEntidadDao extends JpaRepository<GEntidad, GEntidadPK>{
    
}