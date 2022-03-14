package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NFondo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NFondoDao extends JpaRepository<NFondo, Short>{
    
}
