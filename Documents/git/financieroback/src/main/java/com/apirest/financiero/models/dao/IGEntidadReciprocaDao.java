package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GEntidadReciproca;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGEntidadReciprocaDao extends JpaRepository< GEntidadReciproca, String>{
    
}