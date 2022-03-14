package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GModalidadContrato;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGModalidadContratoDao extends JpaRepository<GModalidadContrato, Short>{
    
}