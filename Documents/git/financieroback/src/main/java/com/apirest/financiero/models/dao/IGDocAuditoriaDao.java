package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GDocAuditoria;
import com.apirest.financiero.models.entity.GDocAuditoriaPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGDocAuditoriaDao extends JpaRepository<GDocAuditoria, GDocAuditoriaPK>{
    
}