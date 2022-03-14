package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GFuncionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGFuncionarioDao extends JpaRepository<GFuncionario, String>{
    
}