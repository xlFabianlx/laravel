package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.CCentroCostoCont;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICCentroCostContDao extends JpaRepository<CCentroCostoCont, Long>{
    
}
