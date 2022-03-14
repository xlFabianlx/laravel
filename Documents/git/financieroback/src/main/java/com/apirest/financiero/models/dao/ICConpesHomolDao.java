package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CConpesHomol;

public interface ICConpesHomolDao extends JpaRepository<CConpesHomol, Integer> {
    
}