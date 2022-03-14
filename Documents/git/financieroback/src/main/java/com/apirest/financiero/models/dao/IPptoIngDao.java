package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PptoIng;
import com.apirest.financiero.models.entity.PptoIngPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPptoIngDao extends JpaRepository<PptoIng, PptoIngPK> {
    
}
