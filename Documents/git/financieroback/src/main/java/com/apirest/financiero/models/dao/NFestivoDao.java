package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.NFestivo;

public interface NFestivoDao extends JpaRepository<NFestivo, Integer>{
    
}
