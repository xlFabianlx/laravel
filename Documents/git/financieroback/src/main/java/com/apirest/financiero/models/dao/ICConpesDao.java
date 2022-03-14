package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CConpes;
import com.apirest.financiero.models.entity.CConpesPK;

public interface ICConpesDao extends JpaRepository<CConpes, CConpesPK> {
    
}